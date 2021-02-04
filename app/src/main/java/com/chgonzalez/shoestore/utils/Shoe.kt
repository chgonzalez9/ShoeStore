package com.chgonzalez.shoestore.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// data class for shoe list
@Parcelize
data class Shoe(
        var name: String = "",
        var size: String = "",
        var company: String = "",
        var description: String = ""
) : Parcelable

