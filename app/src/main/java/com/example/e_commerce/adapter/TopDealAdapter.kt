package com.example.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.data.DealsOfTheDayData
import com.example.e_commerce.data.ItemListDataClass

class TopDealAdapter(private val list: ArrayList<DealsOfTheDayData>):RecyclerView.Adapter<TopDealAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_deals_item,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = list[position]

        holder.imageView.setImageResource(current.image)
        holder.imageType.text = current.type
    }


    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.top_deals_image)
        val imageType:TextView = itemView.findViewById(R.id.top_deals_text)

    }
}