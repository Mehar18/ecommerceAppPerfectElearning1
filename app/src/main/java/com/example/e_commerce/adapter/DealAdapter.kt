package com.example.e_commerce.adapter

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.data.DealItem

class DealAdapter(private val listener: OnItemClick ):RecyclerView.Adapter<DealAdapter.DealViewHolder>() {

    private var dealList:ArrayList<DealItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.deals_item,parent,false)
        return DealViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        val current = dealList[position]

        holder.image.setImageResource(current.image)
        holder.name.text = current.name
        holder.price.text = "\u20B9 ${current.price}"
    }

    override fun getItemCount(): Int {
        return dealList.size
    }

    fun updateList(list: ArrayList<DealItem>){
        list.clear()
       this.dealList = list
        notifyDataSetChanged()
    }

    inner class DealViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val image = itemView.findViewById<ImageView>(R.id.deal_item_image)
        val name = itemView.findViewById<TextView>(R.id.deal_item_name)
        val price = itemView.findViewById<TextView>(R.id.deal_item_price)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
               listener.onItemClick(position)
            }
        }
    }

    interface OnItemClick{
        fun onItemClick(position: Int)
    }
}