package com.android.febian.weatherapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.febian.weatherapp.data.source.remote.endpoint.Endpoint
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import com.android.febian.weatherapp.data.source.remote.vo.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val endpoint: Endpoint
) : RemoteDataSource {

    override fun getWeather(city: String): LiveData<ApiResponse<WeatherApiResponse>> {
        val weatherResult = MutableLiveData<ApiResponse<WeatherApiResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                endpoint.getWeather(city).await().let {
                    weatherResult.postValue(ApiResponse.success(it))
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return weatherResult
    }
}