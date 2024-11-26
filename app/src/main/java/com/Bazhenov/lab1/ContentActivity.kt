package com.Bazhenov.lab1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class ContentActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val botttomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        botttomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{
            _, dist, _ ->
            when(dist.id){
                R.id.registerFragment -> botttomNav.visibility = View.GONE
                R.id.loginFragment -> botttomNav.visibility = View.GONE
                R.id.splashFragment -> botttomNav.visibility = View.GONE
                else -> botttomNav.visibility = View.VISIBLE
            }
        }
    }
}