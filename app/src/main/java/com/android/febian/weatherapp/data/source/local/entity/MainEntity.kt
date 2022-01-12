package com.android.febian.weatherapp.data.source.local.entity

data class MainEntity(
    val temp: Float? = null,
    val temp_min: Float? = null,
    val temp_max: Float? = null,
    val pressure: Int? = null,
    val humidity: Int? = null
)
