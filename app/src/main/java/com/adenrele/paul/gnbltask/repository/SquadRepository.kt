package com.adenrele.paul.gnbltask.repository

import com.adenrele.paul.gnbltask.api.ApiService
import com.adenrele.paul.gnbltask.api.mappers.SquadNetworkMapper
import com.adenrele.paul.gnbltask.models.Squad
import com.adenrele.paul.gnbltask.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject


class SquadRepository @Inject constructor(
    private val apiService: ApiService,
    private val networkMapper: SquadNetworkMapper
) {


    fun getSquadForTeam(teamId: Int): Flow<DataState<List<Squad>>> = flow {
        emit(DataState.Loading)

        try {
            val networkSquad = apiService.getSquadForTeam(teamId)
            val teams = networkMapper.mapFromEntityList(networkSquad)
            emit(DataState.Success(teams))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }.flowOn(Dispatchers.IO)
}