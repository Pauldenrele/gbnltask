package com.adenrele.paul.gnbltask.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.repository.MainRepositoryImpl
import com.adenrele.paul.gnbltask.utils.DataState


class HomeViewModel @ViewModelInject constructor(
    private val mainRepositoryImpl: MainRepositoryImpl
) : ViewModel() {

    val competition = mainRepositoryImpl.getCompetitions().asLiveData()
}