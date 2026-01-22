package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.SignupPageBinding
import com.google.android.material.button.MaterialButton

class SignupActivity: AppCompatActivity() {
    lateinit var binding: SignupPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnSignUp.setOnClickListener {
            if(binding.etEmail.text.toString().isEmpty()){
                binding.etEmail.error = "Enter Email"
            }else if(binding.etPassword1.text.toString().isEmpty()){
                binding.etPassword1.error = "Enter password"
            }
            else if(binding.etPassword1.text.toString().length < 6){
                binding.etPassword1.error = "Enter at least 6 digit password"
            }
            else if(binding.etPassword1.text.toString()!=binding.etConfirmPassword1.text.toString()){
                binding.etConfirmPassword1.error = "Enter Same Password"
            }
            else{
                val intent = Intent(this, SigninActivity::class.java)
                intent.putExtra("Email",binding.etEmail.text.toString())
                intent.putExtra("Password",binding.etPassword1.text.toString())
                startActivity(intent)
                finish()
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            }
        }

    }}
