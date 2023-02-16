package com.example.e_commerce

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_commerce.data.PrefManager
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.ui.cart.CartFragment
import com.example.e_commerce.ui.home.HomeFragment
import com.example.e_commerce.ui.login.LoginActivity
import com.example.e_commerce.ui.menu.MenuFragment
import com.example.e_commerce.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        if (prefManager.isLogin()) {
            loadFragment(HomeFragment())
        }else{
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Redirecting To login page")
            progressDialog.show()
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.navigation_cart -> {
                    loadFragment(CartFragment())

                    true
                }
                R.id.navigation_menu -> {
                  loadFragment(MenuFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            addToBackStack(null)
            //disallowAddToBackStack()
            commit()
        }
    }
}