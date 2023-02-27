package com.example.exam

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
//import com.example.exam.databinding.ActivityLoginBinding
import com.example.exam.databinding.ActivityRewardsDetailBinding

class RewardsActivity: AppCompatActivity(){
    private lateinit var binding: ActivityRewardsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Back")
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        }


        binding.imageView.setImageResource(intent.getIntExtra("image",0))
        binding.caption.text = intent.getStringExtra("caption")
        binding.description.text = intent.getStringExtra("description")


//        val data = intent.getParcelableExtra("data") as? DashboardDataClass
//        val data = intent.getParcelableExtra<DashboardDataClass>("data")

//        @Suppress("DEPRECATION")
////        val data = intent.getSerializableExtra("data") as DashboardDataClass
//
//
//
//        val data = intent.getParcelableExtra<DashboardDataClass>("data")
//
//
//        val image = data?.image
//        val caption = data?.caption
//        val description = data?.description
////        val image = data?.image
////        val caption = data?.caption
////        val description = data?.description
////
////        binding?.imageView?.setImageResource(image!!)
////        binding?.caption.text = caption
////        binding?.description.text = description
////
//        binding.imageView.setImageResource(image!!)
//        binding.caption.text = caption
//        binding.description.text = description


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }

}
