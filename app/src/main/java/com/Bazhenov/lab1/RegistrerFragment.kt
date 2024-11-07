package com.Bazhenov.lab1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class RegisterFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_registration, container, false)
        val navController= NavHostFragment.findNavController(this)


        val num_button = root.findViewById<Button>(R.id.phone_num_button)
        val email_button = root.findViewById<Button>(R.id.email_button)
        val user_email_num = root.findViewById<EditText>(R.id.user_email)
        val user_password = root.findViewById<EditText>(R.id.user_password)
        val reg_button = root.findViewById<Button>(R.id.reg_button)
        val storage = requireContext().getSharedPreferences("DataBase", Context.MODE_PRIVATE)


        num_button.setOnClickListener(){
            num_button.setBackgroundColor(Color.parseColor("#9400D3"))
            email_button.setBackgroundColor(Color.parseColor("#673AB7"))
            user_email_num.hint = "Введите телефон"
            user_email_num.inputType = InputType.TYPE_CLASS_PHONE
        }

        email_button.setOnClickListener(){
            email_button.setBackgroundColor(Color.parseColor("#9400D3"))
            num_button.setBackgroundColor(Color.parseColor("#673AB7"))
            user_email_num.hint = "Введите email"
            user_email_num.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        reg_button.setOnClickListener(){
            val email_number = user_email_num.text.toString()
            val repeated_password = root.findViewById<EditText>(R.id.repeated_password)
            if(!(email_number.contains("@")) and (user_email_num.hint == "Введите email")){
                Toast.makeText(activity, "Некорректный email", Toast.LENGTH_SHORT).show()
            }

            else if(!(email_number.contains("+")) and (user_email_num.hint == "Введите телефон")){
                Toast.makeText(activity, "Некорректный номер телефона", Toast.LENGTH_SHORT).show()
            }

            else if(user_password.length() < 8){
                Toast.makeText(activity, "Пароль должен иметь больше 8 символов", Toast.LENGTH_SHORT).show()
            }

            else if(user_password.text.toString() != repeated_password.text.toString()){
                Toast.makeText(activity, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }

            else{
                if(user_email_num.hint == "Введите email"){
                    storage.edit().putString("email", user_email_num.text.toString()).apply()
                }
                else if(user_email_num.hint == "Введите телефон"){
                    storage.edit().putString("phone", user_email_num.text.toString()).apply()
                }
                storage.edit().putString("password", user_password.text.toString()).apply()
                navController.navigate(R.id.oneFragment)
            }
        }
        return root
    }
}