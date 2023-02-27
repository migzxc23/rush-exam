package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.databinding.ActivityLoginBinding
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Realtime Database
        databaseRef = FirebaseDatabase.getInstance().getReference("Users")

        binding.btnLogin.setOnClickListener {
            val mobile = binding.mobile.text.toString()
            val mpin = binding.mpin.text.toString()

            databaseRef.orderByChild("mobile").equalTo(mobile)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            // User exists in the database, retrieve their data
                            val user = snapshot.children.first().getValue(LoginDataClass::class.java)

                            if (user?.mpin == mpin) {
                                // MPIN is correct, login successful
                                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                                val user = RegisterDataClass(user.firstName, user.lastName, mobile, mpin, user.voucher, "fromLogin")
                                intent.putExtra("user",user)
                                startActivity(intent)
                                finish()
                            } else {
                                // MPIN is incorrect, show error message
                                Log.e("LoginActivity", "Incorrect mPIN")
                                // show error message to user
                                Toast.makeText(this@LoginActivity, "Incorrect mPIN", Toast.LENGTH_LONG).show()
                                binding?.mobile.text?.clear()
                                binding?.mpin.text?.clear()
                            }
                        } else {
                            // User does not exist in the database, show error message
                            Log.e("LoginActivity", "User does not exist in the database")
                            // show error message to user
                            Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_LONG).show()
                            binding?.mobile.text?.clear()
                            binding?.mpin.text?.clear()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("LoginActivity", "Database error: ${error.message}")
                        Toast.makeText(this@LoginActivity, "Database error", Toast.LENGTH_LONG).show()
                        // Handle error
                    }
                })
        }
    }
}
