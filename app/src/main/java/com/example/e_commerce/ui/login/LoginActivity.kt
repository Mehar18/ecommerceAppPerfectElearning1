package com.example.e_commerce.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.e_commerce.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signup:TextView = findViewById(R.id.sign_up)
        val login:TextView = findViewById(R.id.log_in)

        signup.setBackgroundColor(resources.getColor(R.color.dark_blue))
        signup.setTextColor(resources.getColor(R.color.white))
        loadFragment(SignupFragment())
        login.setOnClickListener {
            loadFragment(LoginFragment())
            login.setBackgroundColor(resources.getColor(R.color.dark_blue))
            login.setTextColor(resources.getColor(R.color.white))
            signup.setBackgroundColor(resources.getColor(R.color.white))
            signup.setTextColor(resources.getColor(R.color.dark_blue))
        }

        signup.setOnClickListener {
            loadFragment(SignupFragment())
            login.setBackgroundColor(resources.getColor(R.color.white))
            login.setTextColor(resources.getColor(R.color.dark_blue))
            signup.setBackgroundColor(resources.getColor(R.color.dark_blue))
            signup.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_login,fragment)
            commit()
        }
    }
}