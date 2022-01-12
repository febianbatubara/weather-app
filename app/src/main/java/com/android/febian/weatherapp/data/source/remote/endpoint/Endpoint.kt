package com.android.febian.weatherapp.data.source.remote.endpoint

import com.android.febian.weatherapp.BuildConfig
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    //    @GET("weather?q={city}&appid={api_key}")
    @GET("weather")
    fun getWeather(
        @Query("city") city: String,
        @Query("appid") appid: String = BuildConfig.API_KEY
    ): Call<WeatherApiResponse>
}