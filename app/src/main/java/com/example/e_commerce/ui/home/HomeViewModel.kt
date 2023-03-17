package com.example.e_commerce.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce.R
import com.example.e_commerce.data.ItemListDataClass
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val currentUser = FirebaseAuth.getInstance().currentUser

//    val username = currentUser!!.displayName




}