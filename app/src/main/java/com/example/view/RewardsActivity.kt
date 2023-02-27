package com.example.exam


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityRewardsDetailBinding

class RewardsActivity: AppCompatActivity(){
    private lateinit var binding: ActivityRewardsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Back")
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        }


        binding.imageView.setImageResource(intent.getIntExtra("image",0))
        binding.caption.text = intent.getStringExtra("caption")
        binding.description.text = intent.getStringExtra("description")

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Subject")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Share this app to your friends.")
            startActivity(Intent.createChooser(shareIntent, "Share Using"))

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }




}
