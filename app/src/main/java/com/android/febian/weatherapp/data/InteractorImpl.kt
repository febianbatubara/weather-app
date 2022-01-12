package com.android.febian.weatherapp.data

import androidx.lifecycle.LiveData
import com.android.febian.weatherapp.data.source.local.LocalRepository
import com.android.febian.weatherapp.data.source.local.entity.WeatherItemEntity
import com.android.febian.weatherapp.data.source.remote.RemoteRepository
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse
import com.android.febian.weatherapp.data.source.remote.vo.ApiResponse
import com.android.febian.weatherapp.utils.AppExecutors
import com.android.febian.weatherapp.utils.ResponseToEntityConverter
import com.android.febian.weatherapp.vo.Resource
import javax.inject.Inject

class InteractorImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val appExecutors: AppExecutors
) : Interactor {

    override suspend fun getWeather(city: String): LiveData<Resource<WeatherItemEntity>> {
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
                localRepository.insertWeather(weatherEntity)
            }
        }.asLiveData()
    }
}