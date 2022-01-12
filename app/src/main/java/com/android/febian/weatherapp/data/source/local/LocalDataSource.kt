package com.android.febian.weatherapp.data.source.local

import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity

interface LocalDataSource {

    fun getWeather(): WeatherItemEntity

    fun insertWeather(weather: WeatherItemEntity)
}