package com.android.febian.weatherapp.data.source.local

import androidx.lifecycle.LiveData
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity

interface LocalDataSource {

    fun getWeather(): LiveData<WeatherItemEntity>

    fun insertWeather(weather: WeatherItemEntity)
}