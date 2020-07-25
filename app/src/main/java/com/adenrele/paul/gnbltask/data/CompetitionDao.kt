package com.adenrele.paul.gnbltask.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.models.cache.CompetitionCacheEntity

@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(competition: CompetitionCacheEntity) : Long

    @Query("SELECT * FROM COMPETITIONS")
    suspend fun getCompetitions(): List<CompetitionCacheEntity>
}