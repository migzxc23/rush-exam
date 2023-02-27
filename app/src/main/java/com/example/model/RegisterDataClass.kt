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





