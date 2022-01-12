package com.android.febian.weatherapp.data.source.remote.response

import com.squareup.moshi.Json

data class CloudsResponse(
    @field:Json(name = "all") val all: Int
)
