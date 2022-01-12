package com.android.febian.weatherapp.data.source.remote.response

import com.squareup.moshi.Json

data class SysResponse(
    @field:Json(name = "country") val country: String,
    @field:Json(name = "sunrise") val sunrise: String,
    @field:Json(name = "sunset") val sunset: String
)
