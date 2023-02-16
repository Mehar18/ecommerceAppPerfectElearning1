package com.example.e_commerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.data.DealItem

class MyOrderAdapter(private val list: ArrayList<DealItem>) :RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderViewHolder {

        val mView = LayoutInflater.from(parent.context).inflate(R.layout.my_order,parent,false)
        return MyOrderViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyOrderViewHolder, position: Int) {

    }



    class MyOrderViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}