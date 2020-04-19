package com.karzek.daily.http.weather.model

import com.google.gson.annotations.SerializedName
import com.karzek.daily.domain.weather.model.Weather

data class WeatherDataResponse(
    @SerializedName("wind_spd") val windSpeed: Double, //m/s
    @SerializedName("wind_cdir") val windDirection: String,
    @SerializedName("temp") val temperature: Double, //Celsius
    @SerializedName("weather") val weather: WeatherResponse
) {
    fun toModel(): Weather {
        return Weather(weather.code, weather.icon, temperature)
    }
}
