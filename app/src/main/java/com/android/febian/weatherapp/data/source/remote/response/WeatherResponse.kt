package com.android.febian.weatherapp.data.source.remote.response

import com.squareup.moshi.Json

data class WeatherResponse(
    @field:Json(name = "main") var main: String? = null,
    @field:Json(name = "description") var description: String? = null
)
