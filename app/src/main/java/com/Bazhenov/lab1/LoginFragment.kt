package com.Bazhenov.lab1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        val navController = NavHostFragment.findNavController(this)

        val login_status = root.findViewById<CheckBox>(R.id.login_status)
        val storage = requireContext().getSharedPreferences("DataBase", Context.MODE_PRIVATE)
        val login_button = root.findViewById<Button>(R.id.login_button)
        val user_email_phone = root.findViewById<EditText>(R.id.email_button)
        val user_password = root.findViewById<EditText>(R.id.user_password)

        login_button.setOnClickListener() {
            if ((user_email_phone.text.toString() == storage.getString(
                    "email",
                    ""
                ) || (user_email_phone.text.toString() == storage.getString(
                    "phone",
                    ""
                ))) and (user_password.text.toString() == storage.getString("password", ""))
            ) {
                if (login_status.isChecked == true) {
                    storage.edit().putBoolean("login_status", login_status.isChecked).apply()
                    Toast.makeText(activity, login_status.toString(), Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.oneFragment)
                } else {
                    navController.navigate(R.id.oneFragment)
                }
            } else {
                Toast.makeText(activity, "Неправильные данные", Toast.LENGTH_LONG).show()
            }

        }
        return root
    }
}