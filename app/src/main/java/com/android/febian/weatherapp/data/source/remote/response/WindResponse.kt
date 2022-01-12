package com.android.febian.weatherapp.data.source.remote.response

import com.squareup.moshi.Json

data class WindResponse(
    @field:Json(name = "speed") val speed: Float,
    @field:Json(name = "deg") val deg: Int
)
