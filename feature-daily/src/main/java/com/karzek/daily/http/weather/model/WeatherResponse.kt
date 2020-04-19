package com.karzek.daily.http.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("icon") val icon: String,
    @SerializedName("code") val code: String
)
