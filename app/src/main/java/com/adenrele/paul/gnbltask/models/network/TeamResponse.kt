package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TeamResponse(

    @SerializedName("teams")
    @Expose
    var teams: List<TeamNetworkEntity>
)