package com.example.exam

import java.io.Serializable

data class RegisterDataClass(
    var firstName: String? = null,
    var lastName: String? = null,
    var mobile: String? = null,
    val mpin: String? = null,
    var voucher: String? = null,
    var whereFrom:String?= null
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




