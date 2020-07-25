package com.adenrele.paul.gnbltask.data

import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.models.cache.CompetitionCacheEntity
import com.adenrele.paul.gnbltask.models.network.CompetitionNetworkEntity
import com.adenrele.paul.gnbltask.utils.EntityMapper
import javax.inject.Inject



class CacheMapper @Inject constructor() : EntityMapper<CompetitionCacheEntity, Competition> {
    override fun mapFromEntity(entity: CompetitionCacheEntity): Competition {
        return Competition(
            id = entity.id,
            leagueName = entity.leagueName,
            startDate = entity.startDate,
            country = entity.country
        )
    }

    override fun mapToEntity(domainModel: Competition): CompetitionCacheEntity {
        return CompetitionCacheEntity(
            id = domainModel.id,
            leagueName = domainModel.leagueName,
            startDate = domainModel.startDate,
            country = domainModel.country
        )
    }


    fun mapFromEntityList(entities: List<CompetitionCacheEntity>) : List<Competition>{
        return entities.map {
            mapFromEntity(it)
        }
    }

}