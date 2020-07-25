package com.adenrele.paul.gnbltask.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adenrele.paul.gnbltask.models.Squad
import com.adenrele.paul.gnbltask.repository.SquadRepository
import com.adenrele.paul.gnbltask.utils.DataState

class DetailsViewModel @ViewModelInject constructor(
    private val squadRepository: SquadRepository
) : ViewModel() {


    fun getSquadsForTeam(id: Int): LiveData<DataState<List<Squad>>> {
        return squadRepository.getSquadForTeam(id).asLiveData()
    }

}