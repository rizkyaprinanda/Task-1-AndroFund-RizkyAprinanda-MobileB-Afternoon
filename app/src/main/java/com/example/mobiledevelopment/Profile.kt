package com.example.mobiledevelopment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val fullname : String,
    val email : String
) : Parcelable
