package com.example.e_commerce.ui.login

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerce.R


class ProfileBeforeLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_before_login, container, false)
        val loginBtn:Button = view.findViewById(R.id.logIn)
        val signUPBtn:Button = view.findViewById(R.id.signUp)

        loginBtn.setOnClickListener {
            loadFragment(LoginFragment())
        }
        signUPBtn.setOnClickListener {
            loadFragment(SignupFragment())
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