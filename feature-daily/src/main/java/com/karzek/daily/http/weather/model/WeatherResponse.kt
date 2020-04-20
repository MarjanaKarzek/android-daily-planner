package com.karzek.daily.http.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("code") val code: WeatherCodeResponse
)