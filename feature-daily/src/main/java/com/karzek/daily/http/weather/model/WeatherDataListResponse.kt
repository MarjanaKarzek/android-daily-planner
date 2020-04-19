package com.karzek.daily.http.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherDataListResponse(
    @SerializedName("data") val data: List<WeatherDataResponse>?,
    @SerializedName("error") val error: String?
)