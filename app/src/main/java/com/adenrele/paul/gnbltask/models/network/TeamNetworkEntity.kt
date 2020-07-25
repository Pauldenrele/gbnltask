package com.adenrele.paul.gnbltask.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TeamNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("shortName")
    @Expose
    var shortName: String,

    @SerializedName("crestUrl")
    @Expose
    var crestUrl: String?,

    @SerializedName("phone")
    @Expose
    var phone: String?,

    @SerializedName("address")
    @Expose
    var address: String?,

    @SerializedName("website")
    @Expose
    var website: String?,

    @SerializedName("email")
    @Expose
    var email: String?,

    @SerializedName("founded")
    @Expose
    var founded: Int,

    @SerializedName("clubColors")
    @Expose
    var clubColors: String?

)

