package com.adenrele.paul.gnbltask.repository

import com.adenrele.paul.gnbltask.api.ApiService
import com.adenrele.paul.gnbltask.api.mappers.TeamsNetworkMapper
import com.adenrele.paul.gnbltask.models.Team
import com.adenrele.paul.gnbltask.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

class TeamsRepository @Inject constructor(
    private val apiService: ApiService,
    private val networkMapper: TeamsNetworkMapper
) {


    fun getAllTeams(id: Int): Flow<DataState<List<Team>>> = flow {
        emit(DataState.Loading)

        try {
            val networkTeams = apiService.getAllTeamsForLeague(id)
            val teams = networkMapper.mapFromEntityList(networkTeams)
            emit(DataState.Success(teams))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }.flowOn(Dispatchers.IO)


}