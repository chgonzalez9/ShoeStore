package com.chgonzalez.shoestore.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// data class for user credentials
@Parcelize
data class User(
        var email: String = "",
        var password: String = ""
) : Parcelable
