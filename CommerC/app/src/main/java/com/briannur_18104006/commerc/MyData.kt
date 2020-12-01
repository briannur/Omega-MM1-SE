package com.briannur_18104006.commerc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var photo: String
) : Parcelable