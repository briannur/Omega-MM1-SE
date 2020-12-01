package com.rodojoshuasaragih_18104021.detailpenawaran

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable