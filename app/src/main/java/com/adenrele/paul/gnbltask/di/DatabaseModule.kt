package com.adenrele.paul.gnbltask.di

import android.content.Context
import androidx.room.Room
import com.adenrele.paul.gnbltask.data.AppDatabase
import com.adenrele.paul.gnbltask.data.CompetitionDao
import com.adenrele.paul.gnbltask.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context, AppDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideCompetitionsDao(appDatabase: AppDatabase): CompetitionDao {
        return appDatabase.competitionsDao()
    }
}