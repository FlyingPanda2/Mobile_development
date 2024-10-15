package com.Bazhenov.lab1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_page)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val login_status = findViewById<CheckBox>(R.id.login_status)
        val storage = getSharedPreferences("DataBase", Context.MODE_PRIVATE)
        val login_button = findViewById<Button>(R.id.login_button)
        val user_email_phone = findViewById<EditText>(R.id.user_email)
        val user_password = findViewById<EditText>(R.id.user_password)

        login_button.setOnClickListener(){
            if((user_email_phone.text.toString() == storage.getString("email", "") || (user_email_phone.text.toString() == storage.getString("phone", ""))) and (user_password.text.toString() == storage.getString("password", ""))){
                if(login_status.isChecked == true){
                    storage.edit().putBoolean("login_status", login_status.isChecked).apply()
                    Toast.makeText(this, login_status.toString(), Toast.LENGTH_SHORT)
                    val intent = Intent(this, ContentActivity::class.java)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this, ContentActivity::class.java)
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this, "Неправильные данные", Toast.LENGTH_LONG).show()
            }
        }


    }
}