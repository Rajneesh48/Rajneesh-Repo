package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.SigninPageBinding
import com.google.android.material.button.MaterialButton

class SigninActivity: AppCompatActivity() {
    lateinit var binding: SigninPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SigninPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        binding.etEmail = findViewById(R.id.etEmail)
//        binding.btnSignIn = findViewById(R.id.btnSignIn)
//        binding.etPassword = findViewById(R.id.etPassword)
        intent.let {
            binding.etEmail.setText(it.getStringExtra("Email").toString())
            binding.etPassword.setText(it.getStringExtra("Password").toString())

        }
            binding.btnSignIn.setOnClickListener {
                Toast.makeText(this, "signin successful", Toast.LENGTH_SHORT).show()
            }
        }

    }
