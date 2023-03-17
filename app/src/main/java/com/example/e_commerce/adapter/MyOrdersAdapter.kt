package com.example.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.data.MyOrderItem

class MyOrdersAdapter(private val myOrdersList:ArrayList<MyOrderItem>):RecyclerView.Adapter<MyOrdersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.my_orders_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = myOrdersList[position]
        val number = position+1
        holder.serialNumer.text = number.toString()
        holder.name.text = current.name
        holder.price.text="₹ ${current.price}"
    }

    override fun getItemCount(): Int {
        return myOrdersList.size
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val serialNumer = itemView.findViewById<TextView>(R.id.myOrder_serial_number)
        val name = itemView.findViewById<TextView>(R.id.myOrder_item_name)
        val price = itemView.findViewById<TextView>(R.id.myOrder_price)


    }
}
