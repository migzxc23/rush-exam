package com.example.exam

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var binding : ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setContentView(R.layout.activity_login)
        supportActionBar?.setTitle("Back")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}