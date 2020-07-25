package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CompetitionNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("currentSeason")
    @Expose
    var season: Season?,

    @SerializedName("area")
    @Expose
    var area: Area
)

data class Season(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("startDate")
    @Expose
    var startDate: String? = null,

    @SerializedName("endDate")
    @Expose
    var endDate: String,

    @SerializedName("currentMatchDay")
    @Expose
    var currentMatchDay: Int
)


data class Area(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String
)
