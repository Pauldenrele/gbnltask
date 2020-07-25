package com.adenrele.paul.gnbltask.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val id : Int,
    val name: String,
    val crestUrl: String?,
    val address: String?,
    val phone: String?,
    val website: String?,
    val email: String?,
    val founded: Int,
    val colours: String?,
    val shortName: String
) : Parcelable