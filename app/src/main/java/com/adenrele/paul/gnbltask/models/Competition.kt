package com.adenrele.paul.gnbltask.models


data class Competition(
    val id: Int,
    val leagueName: String,
    val country: String,
    val startDate: String? = null
)