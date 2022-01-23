package com.rohmanbeny.dicodingbeny.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata (
    var desc:String ? = "",
    var lokasi:String ? = "",
    var nama:String ? = "",
    var poster:String ? = "",
    var rating:String ? = ""
) : Parcelable