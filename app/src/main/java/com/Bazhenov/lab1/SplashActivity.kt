package com.Bazhenov.lab1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val PBar = findViewById<ProgressBar>(R.id.progressBar)
        val storage = getSharedPreferences("DataBase", Context.MODE_PRIVATE)

        if((storage.getString("email", "").isNullOrEmpty()) and (storage.getString("phone", "")).isNullOrEmpty()){
            val RegPage = Intent(this, MainActivity::class.java)
            startActivity(RegPage)
        }

        else if(storage.getBoolean("login_status", false) == true) {
            val ContentPage = Intent(this, ContentActivity::class.java)
            startActivity(ContentPage)
        }

        else if(storage.getBoolean("login_status", false) == false){
            val LoginPage = Intent(this, LoginActivity::class.java)
            startActivity(LoginPage)
        }
    }
}