package com.adenrele.paul.gnbltask.models.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "competitions")
data class CompetitionCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "leagueName")
    var leagueName: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "startDate")
    var startDate: String?
)