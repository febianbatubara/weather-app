package com.android.febian.weatherapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_entities LIMIT 1")
    fun getWeather(): LiveData<WeatherItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: WeatherItemEntity)
}