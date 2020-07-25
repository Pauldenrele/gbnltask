package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SquadNetworkEntity(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("position") @Expose val position: String?,
    @SerializedName("teamId") @Expose var teamId: Int?,
    @SerializedName("dateOfBirth") @Expose var birthdate: String?,
    @SerializedName("countryOfBirth") @Expose var country: String?
)