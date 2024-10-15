package com.Bazhenov.lab1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reg_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num_button = findViewById<Button>(R.id.phone_num_button)
        val email_button = findViewById<Button>(R.id.email_button)
        val user_email_num = findViewById<EditText>(R.id.user_email)
        val user_password = findViewById<EditText>(R.id.user_password)
        val reg_button = findViewById<Button>(R.id.reg_button)
        val storage = getSharedPreferences("DataBase", Context.MODE_PRIVATE)


        num_button.setOnClickListener(){
            num_button.setBackgroundColor(Color.parseColor("#9400D3"))
            email_button.setBackgroundColor(Color.parseColor("#673AB7"))
            user_email_num.hint = "Введите телефон"
        }

        email_button.setOnClickListener(){
            email_button.setBackgroundColor(Color.parseColor("#9400D3"))
            num_button.setBackgroundColor(Color.parseColor("#673AB7"))
            user_email_num.hint = "Введите email"
        }

        reg_button.setOnClickListener(){
            val email_number = user_email_num.text.toString()
            val repeated_password = findViewById<EditText>(R.id.repeated_password)
            if(!(email_number.contains("@")) and (user_email_num.hint == "Введите email")){
                Toast.makeText(this, "Некорректный email", Toast.LENGTH_SHORT).show()
            }

            else if(!(email_number.contains("+")) and (user_email_num.hint == "Введите телефон")){
                Toast.makeText(this, "Некорректный номер телефона", Toast.LENGTH_SHORT).show()
            }

            else if(user_password.length() < 8){
                Toast.makeText(this, "Пароль должен иметь больше 8 символов", Toast.LENGTH_SHORT).show()
            }

            else if(user_password.text.toString() != repeated_password.text.toString()){
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }

            else{
                if(user_email_num.hint == "Введите email"){
                    storage.edit().putString("email", user_email_num.text.toString()).apply()
                }
                else if(user_email_num.hint == "Введите телефон"){
                    storage.edit().putString("phone", user_email_num.text.toString()).apply()
                }
                storage.edit().putString("password", user_password.text.toString()).apply()
                val ContentPage = Intent(this, ContentActivity::class.java)
                startActivity(ContentPage)
            }
        }

    }
}