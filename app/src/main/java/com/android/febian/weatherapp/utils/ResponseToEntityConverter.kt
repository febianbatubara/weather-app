package com.android.febian.weatherapp.utils

import com.android.febian.weatherapp.data.source.local.entity.*
import com.android.febian.weatherapp.data.source.remote.response.WeatherApiResponse

object ResponseToEntityConverter {

    fun getEntity(data: WeatherApiResponse): WeatherItemEntity {
        with(data) {
            val weatherEntity = WeatherEntity(
                weather[0].id,
                weather[0].main,
                weather[0].description,
            )
            val mainEntity = MainEntity(
                main?.temp,
                main?.temp_min,
                main?.temp_max
            )
            val windEntity = WindEntity(
                wind?.speed,
                wind?.deg,
            )
            val cloudsEntity = CloudsEntity(
                clouds?.all
            )
            val sysEntity = SysEntity(
                sys?.speed,
                sys?.deg,
            )
            return WeatherItemEntity(
                id,
                weatherEntity,
                mainEntity,
                visibility,
                windEntity,
                cloudsEntity,
                dt,
                sysEntity,
                timezone,
                name,
                cod
            )
        }
    }
}