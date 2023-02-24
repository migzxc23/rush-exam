package com.example.exam

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity(){

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

        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = RegisterDataClass(firstName, lastName, mobile, mpin)
        database.child(firstName).setValue(user).addOnSuccessListener {
            binding.firstName.text?.clear()
            binding.lastName.text?.clear()
            binding.mobile.text?.clear()
            binding.mpin.text?.clear()
            binding.confMpin.text?.clear()

            Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()

        }.addOnFailureListener{
            Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()
        }


    }
    }
}