package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnSignUp: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signup_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etEmail = findViewById(R.id.etEmail)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            if(etEmail.text.toString().isEmpty()){
                etEmail.error = "Enter Email"
            }else if(etPassword.text.toString().isEmpty()){
                    etPassword.error = "Enter password"
            }
            else if(etPassword.text.toString().length < 6){
                etPassword.error = "Enter at least 6 digit password"
            }
            else if (etPassword.text.toString()!=etPassword.text.toString()){
                etPassword.error = "Password Mismatch"
            }
            else{
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            }
        }

    }
}