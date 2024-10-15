package com.Bazhenov.lab1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class ContentActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

//        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//
//        val botttomBar = findViewById<NavigationView>(R.id.bottom_nav)
//        botttomBar.setupWithNavController(navController)

    }
}