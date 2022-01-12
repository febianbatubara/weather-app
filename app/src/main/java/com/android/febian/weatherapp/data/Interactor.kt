package com.android.febian.weatherapp.data

import androidx.lifecycle.LiveData
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.vo.Resource

interface Interactor {

    suspend fun getWeather(
        city: String
    ): LiveData<Resource<WeatherItemEntity>>
}