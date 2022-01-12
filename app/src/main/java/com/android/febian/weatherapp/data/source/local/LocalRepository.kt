package com.android.febian.weatherapp.data.source.local

import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.data.source.local.room.WeatherDao
import javax.inject.Inject

class LocalRepository @Inject constructor(private val weatherDao: WeatherDao) : LocalDataSource {

    override fun getWeather(): WeatherItemEntity = weatherDao.getWeather()

    override fun insertWeather(weather: WeatherItemEntity) = weatherDao.insertWeather(weather)
}