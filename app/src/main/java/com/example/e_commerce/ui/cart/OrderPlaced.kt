package com.example.e_commerce.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.adapter.MyOrdersAdapter
import com.example.e_commerce.ui.home.HomeFragment


class OrderPlaced : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_order_placed, container, false)
        val homeButton : Button = view.findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            loadFragment(HomeFragment())

        }


        return view
    }

    private fun loadFragment(fragment: Fragment) {
        val manager = (requireContext() as AppCompatActivity).supportFragmentManager
        manager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }


}