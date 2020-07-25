package com.adenrele.paul.gnbltask.api.mappers

import com.adenrele.paul.gnbltask.models.Squad
import com.adenrele.paul.gnbltask.models.network.SquadNetworkEntity
import com.adenrele.paul.gnbltask.models.network.SquadResponse
import com.adenrele.paul.gnbltask.utils.EntityMapper
import javax.inject.Inject


class SquadNetworkMapper @Inject constructor() :
    EntityMapper<SquadNetworkEntity, Squad> {

    override fun mapFromEntity(entity: SquadNetworkEntity): Squad {
        return Squad(
            id = entity.id,
            name = entity.name,
            position = entity.position,
            teamId = entity.teamId,
            country = entity.country,
            birthDate = entity.birthdate
        )
    }

    override fun mapToEntity(domainModel: Squad): SquadNetworkEntity {
        return SquadNetworkEntity(
            id = domainModel.id,
            teamId = domainModel.teamId,
            position = domainModel.position,
            name = domainModel.name,
            country = domainModel.country,
            birthdate = domainModel.birthDate
        )
    }


    fun mapFromEntityList(entities: SquadResponse): List<Squad> {
        return entities.squad.map {
            mapFromEntity(it)
        }
    }

}