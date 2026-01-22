package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.DashboardActivityBinding


class Dashboard : AppCompatActivity() {
    lateinit var binding: DashboardActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn.setOnClickListener {
            if (binding.etEmail.text.toString().isEmpty()) {
                binding.etEmail.error = ("enter Email")
            }else{
                var intent = Intent(this, SigninActivity::class.java)
                intent.putExtra("email",binding.etEmail.text.toString())
                startActivity(intent)
                Toast.makeText(this, "sign in successful", Toast.LENGTH_SHORT).show()
            }



            }}
    }
