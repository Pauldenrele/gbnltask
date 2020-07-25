package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CompetitionResponse(
    @SerializedName("count")
    @Expose
    var count: Int,

    @SerializedName("filters")
    @Expose
    var filters: Filters? = null,

    @SerializedName("competitions")
    @Expose
    var competitions: List<CompetitionNetworkEntity>

)


class Filters {}