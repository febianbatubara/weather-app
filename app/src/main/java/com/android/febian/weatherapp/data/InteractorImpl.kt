package com.android.febian.weatherapp.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.android.febian.weatherapp.data.source.local.LocalRepository
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.data.source.remote.RemoteRepository
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import com.android.febian.weatherapp.data.source.remote.vo.ApiResponse
import com.android.febian.weatherapp.utils.AppExecutors
import com.android.febian.weatherapp.utils.ResponseToEntityConverter
import com.android.febian.weatherapp.vo.Resource
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class InteractorImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val appExecutors: AppExecutors
) : Interactor {

    override fun getWeather(city: String): LiveData<Resource<WeatherItemEntity>> {
        return object :
            NetworkBoundResource<WeatherItemEntity, WeatherApiResponse>(appExecutors) {
            public override fun loadFromDB(): LiveData<WeatherItemEntity> =
                localRepository.getWeather()

            override fun shouldFetch(data: WeatherItemEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<WeatherApiResponse>> =
                remoteRepository.getWeather(city)

            public override fun saveCallResult(data: WeatherApiResponse) {
                val weatherEntity = ResponseToEntityConverter.getEntity(data)
                weatherEntity.updatedAt = getCurrentDate()
                localRepository.insertWeather(weatherEntity)
            }
        }.asLiveData()
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val today = Date()
        val format = SimpleDateFormat("dd/MM/yyy hh:mm a")
        return format.format(today)
    }
}