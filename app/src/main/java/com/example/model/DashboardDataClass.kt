package com.example.exam

import android.os.Parcel
import android.os.Parcelable

data class DashboardDataClass(
    val image: Int,
    val caption: String,
    val description: String


): Parcelable {
    // Implement the Parcelable.Creator interface
    companion object CREATOR : Parcelable.Creator<DashboardDataClass> {
        override fun createFromParcel(parcel: Parcel): DashboardDataClass {
            return DashboardDataClass(
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readString()!!
            )
        }

        override fun newArray(size: Int): Array<DashboardDataClass?> {
            return arrayOfNulls(size)
        }
    }

    // Override the writeToParcel method
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(caption)
        parcel.writeString(description)
    }

    // Implement the describeContents method
    override fun describeContents(): Int {
        return 0
    }
}
