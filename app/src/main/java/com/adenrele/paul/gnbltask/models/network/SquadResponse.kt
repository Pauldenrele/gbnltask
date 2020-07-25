package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SquadResponse(
    @SerializedName("id")
    @Expose
    val id: Int,

    @Expose
    @SerializedName("squad")
    val squad: List<SquadNetworkEntity>
)