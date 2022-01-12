package com.android.febian.weatherapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_entities")
data class WeatherItemEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movieId")
    var weather_id: Int? = null,

    @Embedded var weather: WeatherEntity? = null,

    @Embedded var main: MainEntity? = null,

    @ColumnInfo(name = "visibility")
    var visibility: Int? = null,

    @Embedded var wind: WindEntity? = null,

    @Embedded var clouds: CloudsEntity? = null,

    @ColumnInfo(name = "dt")
    var dt: Int? = null,

    @Embedded var sys: SysEntity? = null,

    @ColumnInfo(name = "timezone")
    var timezone: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "cod")
    var cod: Int? = null,

    @ColumnInfo(name = "updatedAt")
    var updatedAt: String? = null
)
