package com.android.febian.weatherapp.data.source.remote.response

import com.squareup.moshi.Json

data class WeatherApiResponse(
    @field:Json(name = "weather") var weather: List<WeatherResponse>? = null,
    @field:Json(name = "main") var main: MainResponse? = null,
    @field:Json(name = "visibility") var visibility: Int? = null,
    @field:Json(name = "wind") var wind: WindResponse? = null,
    @field:Json(name = "clouds") var clouds: CloudsResponse? = null,
    @field:Json(name = "dt") var dt: Int? = null,
    @field:Json(name = "sys") var sys: SysResponse? = null,
    @field:Json(name = "timezone") var timezone: Int? = null,
    @field:Json(name = "id") var id: Int? = null,
    @field:Json(name = "name") var name: String? = null,
    @field:Json(name = "cod") var cod: Int? = null
)
