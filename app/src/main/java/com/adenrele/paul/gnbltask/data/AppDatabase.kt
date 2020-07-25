package com.adenrele.paul.gnbltask.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adenrele.paul.gnbltask.models.cache.CompetitionCacheEntity

@Database(
    entities = [CompetitionCacheEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun competitionsDao(): CompetitionDao
}