package com.android.febian.weatherapp.data.source.remote

import androidx.lifecycle.LiveData
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import com.android.febian.weatherapp.data.source.remote.vo.ApiResponse

interface RemoteDataSource {

    suspend fun getWeather(
        city: String
    ): LiveData<ApiResponse<WeatherApiResponse>>
}