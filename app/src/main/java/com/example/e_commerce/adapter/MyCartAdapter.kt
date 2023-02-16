package com.example.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.data.DealItem

class MyCartAdapter(private val list:ArrayList<DealItem>):RecyclerView.Adapter<MyCartAdapter.CartViewHolder>() {

//    private var dealList:ArrayList<DealItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_cart_item,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val current = list[position]
        val number = position+1
        holder.serialNumer.text = number.toString()
        holder.name.text = current.name
        holder.price.text = "\u20B9 ${current.price}"
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class CartViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val serialNumer = itemView.findViewById<TextView>(R.id.serial_number)
        val name = itemView.findViewById<TextView>(R.id.cart_item_name)
        val price = itemView.findViewById<TextView>(R.id.cart_item_price)

    }


}