package com.example.exam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.DetailInterface
import com.example.exam.databinding.ItemListBinding
import com.google.firebase.database.*



class DashboardActivity: AppCompatActivity(),DetailInterface {

    private var firebaseDatabase: FirebaseDatabase? = null
    private var databaseReference: DatabaseReference? = null

    private lateinit var binding: ItemListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = DashboardAdapter(VoucherObjects.voucherObjects, this@DashboardActivity)
        binding?.taskRv?.adapter = adapter

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase?.getReference("Users")

        // REGISTER
        @Suppress("DEPRECATION")
        val user = intent.getSerializableExtra("user") as RegisterDataClass

        if(user.whereFrom == "fromRegister"){
            val firstName = user.firstName
            val lastName = user.lastName
            val mobile = user.mobile
            val voucher = user.voucher
            val fullName = "$firstName $lastName"
            binding?.fullName.text = fullName
            binding?.mobileNumber.text = mobile
            binding?.voucher.text = voucher
        }
        else if(user.whereFrom == "fromLogin"){
            val firstName = user.firstName
            val lastName = user.lastName
            val mobile = user.mobile
            val voucher = user.voucher
            val fullName = "$firstName $lastName"
            binding?.fullName.text = fullName
            binding?.mobileNumber.text = mobile
            binding?.voucher.text = voucher
        }

    }

    override fun getDetail(image: Int, caption: String, description: String) {
        val intent = Intent(this, RewardsActivity::class.java)
        intent.putExtra("image", image)
        intent.putExtra("caption",caption)
        intent.putExtra("description", description)
        startActivity(intent)
    }




}