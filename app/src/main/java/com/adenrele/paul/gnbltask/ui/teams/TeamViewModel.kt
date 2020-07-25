package com.adenrele.paul.gnbltask.ui.teams

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adenrele.paul.gnbltask.models.Team
import com.adenrele.paul.gnbltask.repository.TeamsRepository
import com.adenrele.paul.gnbltask.utils.DataState


class TeamViewModel @ViewModelInject constructor(
    private val teamsRepository: TeamsRepository
) : ViewModel() {


    fun getTeams(id: Int): LiveData<DataState<List<Team>>> {
        return teamsRepository.getAllTeams(id).asLiveData()
    }
}