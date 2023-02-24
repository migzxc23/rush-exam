package com.example.exam

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity(){





    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    supportActionBar?.setTitle("Back")
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    setContentView(R.layout.activity_register)

}
}