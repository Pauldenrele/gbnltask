package com.adenrele.paul.gnbltask.api.mappers

import com.adenrele.paul.gnbltask.models.Team
import com.adenrele.paul.gnbltask.models.network.TeamNetworkEntity
import com.adenrele.paul.gnbltask.models.network.TeamResponse
import com.adenrele.paul.gnbltask.utils.EntityMapper
import javax.inject.Inject

class TeamsNetworkMapper @Inject constructor() : EntityMapper<TeamNetworkEntity, Team> {

    override fun mapFromEntity(entity: TeamNetworkEntity): Team {
        return Team(
            email = entity.email,
            id = entity.id,
            name = entity.name,
            shortName = entity.shortName,
            phone = entity.phone,
            website = entity.website,
            founded = entity.founded,
            colours = entity.clubColors,
            address = entity.address,
            crestUrl = entity.crestUrl
        )
    }

    override fun mapToEntity(domainModel: Team): TeamNetworkEntity {
        return TeamNetworkEntity(
            email = domainModel.email,
            id = domainModel.id,
            name = domainModel.name,
            shortName = domainModel.shortName,
            phone = domainModel.phone,
            website = domainModel.website,
            founded = domainModel.founded,
            clubColors = domainModel.colours,
            address = domainModel.address,
            crestUrl = domainModel.crestUrl
        )
    }


    fun mapFromEntityList(entities: TeamResponse): List<Team> {
        return entities.teams.map {
            mapFromEntity(it)
        }
    }
}