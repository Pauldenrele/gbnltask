package com.adenrele.paul.gnbltask.api

import com.adenrele.paul.gnbltask.models.network.CompetitionResponse
import com.adenrele.paul.gnbltask.models.network.SquadResponse
import com.adenrele.paul.gnbltask.models.network.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("competitions")
    suspend fun getCompetitions(): CompetitionResponse

    @GET("competitions/{id}/teams")
    suspend fun getAllTeamsForLeague(@Path("id") id: Int) : TeamResponse

    @GET("teams/{teamId}")
    suspend fun getSquadForTeam(@Path("teamId") teamId: Int?): SquadResponse
}