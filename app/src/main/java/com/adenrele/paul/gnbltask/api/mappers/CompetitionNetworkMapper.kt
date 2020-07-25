package com.adenrele.paul.gnbltask.api.mappers

import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.models.network.Area
import com.adenrele.paul.gnbltask.models.network.CompetitionNetworkEntity
import com.adenrele.paul.gnbltask.models.network.CompetitionResponse
import com.adenrele.paul.gnbltask.models.network.Season
import com.adenrele.paul.gnbltask.utils.EntityMapper
import javax.inject.Inject


class CompetitionNetworkMapper @Inject constructor() :
    EntityMapper<CompetitionNetworkEntity, Competition> {

    override fun mapFromEntity(entity: CompetitionNetworkEntity): Competition {
        return Competition(
            id = entity.id,
            leagueName = entity.name,
            startDate = entity.season?.startDate,
            country = entity.area.name
        )
    }

    override fun mapToEntity(domainModel: Competition): CompetitionNetworkEntity {
        return CompetitionNetworkEntity(
            id = domainModel.id,
            season = Season(0, domainModel.startDate, "", 0),
            name = domainModel.leagueName,
            area = Area(0, domainModel.country)
        )
    }

    fun mapFromEntityList(entities: CompetitionResponse): List<Competition> {
        return entities.competitions.map {
            mapFromEntity(it)
        }
    }
}