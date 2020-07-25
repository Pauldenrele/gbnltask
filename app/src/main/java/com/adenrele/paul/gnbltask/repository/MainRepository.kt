package com.adenrele.paul.gnbltask.repository

import com.adenrele.paul.gnbltask.api.ApiService
import com.adenrele.paul.gnbltask.api.mappers.CompetitionNetworkMapper
import com.adenrele.paul.gnbltask.data.CacheMapper
import com.adenrele.paul.gnbltask.data.CompetitionDao
import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl
@Inject constructor(
    private val apiService: ApiService,
    private val cacheMapper: CacheMapper,
    private val competitionNetworkMapper: CompetitionNetworkMapper,
    private val competitionDao: CompetitionDao
) {

     fun getCompetitions(): Flow<DataState<List<Competition>>> = flow {
        emit(DataState.Loading)

        try {
            val networkCompetitions = apiService.getCompetitions()
            val competitions = competitionNetworkMapper.mapFromEntityList(networkCompetitions)
            for (competition in competitions) {
                competitionDao.insert(cacheMapper.mapToEntity(competition))
            }

            val cachedCompetition = competitionDao.getCompetitions()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedCompetition)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}