package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

open class RegisterActivity : AppCompatActivity(){

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    FirebaseApp.initializeApp(this)
    supportActionBar?.setTitle("Back")
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    setContentView(binding.root)


    binding.btnRegister.setOnClickListener{
        val firstName = binding?.firstName.text.toString()
        val lastName = binding?.lastName.text.toString()
        val mobile = binding?.mobile.text.toString()
        val mpin = binding?.mpin.text.toString()
        val voucher = generateRandomVarchar(5)

        database = FirebaseDatabase.getInstance().getReference("Users")

        val user = RegisterDataClass(firstName, lastName, mobile, mpin, voucher)
        Log.e("=====", user.toString())
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("user",user)
        startActivity(intent)

        

        database.child(mobile).setValue(user).addOnSuccessListener {
            binding.firstName.text?.clear()
            binding.lastName.text?.clear()
            binding.mobile.text?.clear()
            binding.mpin.text?.clear()
            binding.confMpin.text?.clear()


            Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()



        }



    }
    }

    fun generateRandomVarchar(length: Int): String {
        val chars = "abcd2efghij5k4l5mn4o557pqrstuvwxyzABC7D4E1FG4H7IJ47Ks7aL80MNOPQR9STUVWXYZ1234567890".toCharArray()
        val random = Random()
        val sb = StringBuilder(length)

        for (i in 0 until length) {
            val randomIndex = random.nextInt(chars.size)
            sb.append(chars[randomIndex])
        }

        return sb.toString()
    }
}

