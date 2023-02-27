package com.example.exam

import java.io.Serializable

data class RegisterDataClass(
    var firstName: String,
    var lastName: String,
    var mobile: String,
    val mpin: String,
    var voucher: String
): Serializable
//    fun getirstName() : String{
//        return firstName
//    }
//
//    fun setfirstName(firstName: String) {
//        this.firstName = firstName
//    }
//    fun getlastName() : String{
//        return lastName
//    }
//
//    fun setlastName(lastName: String) {
//        this.lastName = lastName
//    }
//    fun getmobile() : String{
//        return mobile
//    }
//
//    fun setmobile(mobile: String) {
//        this.mobile = mobile
//    }
//
//    fun getvoucher() : String{
//        return voucher
//    }
//
//    fun setvoucher() {
//        this.voucher = voucher
//    }




