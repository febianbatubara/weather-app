package com.android.febian.weatherapp.data.source.remote.endpoint

import com.android.febian.weatherapp.BuildConfig
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("weather?q={city}&appid={api_key}")
    suspend fun getWeather(
        @Path("city") city: String,
        @Path("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<WeatherApiResponse>
}