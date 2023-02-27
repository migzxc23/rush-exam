package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.DetailInterface
import com.example.exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnLogin?.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Here we will start the exercise", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding?.btnRegister?.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }

//    override fun getDetail(image: Int, caption: String, description: String) {
//        val intent = Intent(this, RewardsActivity::class.java)
//        intent.putExtra("image", image)
//        intent.putExtra("caption",caption)
//        intent.putExtra("description", description)
//        startActivity(intent)
//    }
}