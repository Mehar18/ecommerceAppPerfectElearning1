package com.example.e_commerce.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.auth.UserProfileChangeRequest


class SignupFragment : Fragment() {
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
        val mView = inflater.inflate(R.layout.fragment_signup, container, false)
        val firstName = mView.findViewById<TextInputEditText>(R.id.first_name)
        val lastName = mView.findViewById<TextInputEditText>(R.id.last_name)
        val email = mView.findViewById<TextInputEditText>(R.id.email_sign_up)
        val password = mView.findViewById<TextInputEditText>(R.id.password_sign_up)
        val confirmPassword = mView.findViewById<TextInputEditText>(R.id.confirm_password_signup)
        val signupButton = mView.findViewById<Button>(R.id.get_started)

        prefManager = PrefManager(requireContext())


        signupButton.setOnClickListener {
            if(password.text.toString()==confirmPassword.text.toString()) {
                firebaseAuth.createUserWithEmailAndPassword(
                    email.text.toString(),
                    password.text.toString()
                )
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val firebaseUser = FirebaseAuth.getInstance().currentUser

                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName("${firstName.text.toString()} ${lastName.text.toString()}")
                                .build()
                            firebaseUser!!.updateProfile(profileUpdates)
                                .addOnCompleteListener { innerTask ->
                                    if (innerTask.isSuccessful) {
                                        Log.d("Firebase", "User profile updated.")
                                    } else {
                                        Log.d("Firebase", "User profile update failed.")
                                    }
                                }
                            startActivity(Intent(requireContext(), MainActivity::class.java))
                            prefManager.setLogin(true)

                        } else {
                            // Sign up failed
                        }
                    }
            }else{
                Toast.makeText(requireContext(),"Password not matched",Toast.LENGTH_SHORT).show()
            }
        }

        return mView
    }


}