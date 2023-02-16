package com.example.e_commerce.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel : ViewModel() {


    private val currentUser = FirebaseAuth.getInstance().currentUser


    val email = currentUser!!.email
    val username = currentUser!!.displayName

}