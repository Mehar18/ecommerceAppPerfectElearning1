package com.example.e_commerce.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.e_commerce.MainActivity
import com.example.e_commerce.R
import com.example.e_commerce.data.PrefManager
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var prefManager: PrefManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_login, container, false)

        prefManager = PrefManager(requireContext())
        val email:TextInputEditText = mView.findViewById(R.id.email_login)
        val password:TextInputEditText = mView.findViewById(R.id.password_login)


        val loginButton :Button = mView.findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            firebaseAuth.signInWithEmailAndPassword(
                email.text!!.trim().toString(),
                password.text.toString()
            )
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        prefManager.setLogin(true)
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                    } else {
                        email.text = null
                        password.text = null
                        Toast.makeText(mView.context, "No user found", Toast.LENGTH_LONG).show()
                    }
                }
        }

        return mView
    }

}