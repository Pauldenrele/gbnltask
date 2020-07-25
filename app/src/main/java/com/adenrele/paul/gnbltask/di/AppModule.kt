package com.adenrele.paul.gnbltask.di

import android.app.Application
import com.adenrele.paul.gnbltask.R
import com.adenrele.paul.gnbltask.api.ApiService
import com.adenrele.paul.gnbltask.api.mappers.CompetitionNetworkMapper
import com.adenrele.paul.gnbltask.api.mappers.SquadNetworkMapper
import com.adenrele.paul.gnbltask.api.mappers.TeamsNetworkMapper
import com.adenrele.paul.gnbltask.data.CacheMapper
import com.adenrele.paul.gnbltask.data.CompetitionDao
import com.adenrele.paul.gnbltask.repository.MainRepositoryImpl
import com.adenrele.paul.gnbltask.repository.SquadRepository
import com.adenrele.paul.gnbltask.repository.TeamsRepository
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        apiService: ApiService,
        cacheMapper: CacheMapper,
        competitionNetworkMapper: CompetitionNetworkMapper,
        competitionDao: CompetitionDao
    ): MainRepositoryImpl {
        return MainRepositoryImpl(
            apiService,
            cacheMapper,
            competitionNetworkMapper,
            competitionDao
        )
    }


    @Singleton
    @Provides
    fun provideTeamsRepository(
        apiService: ApiService,
        networkMapper: TeamsNetworkMapper
    ): TeamsRepository {
        return TeamsRepository(
            apiService,
            networkMapper
        )
    }


    @Singleton
    @Provides
    fun provideSquadRepository(
        apiService: ApiService,
        networkMapper: SquadNetworkMapper
    ): SquadRepository {
        return SquadRepository(
            apiService,
            networkMapper
        )
    }


    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.ic_baseline_sports_soccer_24)
            .error(R.drawable.ic_baseline_sports_soccer_24)

    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }
}