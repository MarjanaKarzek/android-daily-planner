package com.karzek.daily.http.weather.model

import com.google.gson.annotations.SerializedName
import com.karzek.daily.R.drawable
import java.util.Calendar

enum class WeatherCodeResponse {
    @SerializedName("200")
    THUNDER_STORM_LIGHT_RAIN,

    @SerializedName("201")
    THUNDER_STORM_RAIN,

    @SerializedName("202")
    THUNDER_STORM_HEAVY_RAIN,

    @SerializedName("230")
    THUNDER_STORM_LIGHT_DRIZZLE,

    @SerializedName("231")
    THUNDER_STORM_DRIZZLE,

    @SerializedName("232")
    THUNDER_STORM_HEAVY_DRIZZLE,

    @SerializedName("233")
    THUNDER_STORM_HAIL,

    @SerializedName("300")
    LIGHT_DRIZZLE,

    @SerializedName("301")
    DRIZZLE,

    @SerializedName("302")
    HEAVY_DRIZZLE,

    @SerializedName("500")
    LIGHT_RAIN,

    @SerializedName("501")
    MODERATE_RAIN,

    @SerializedName("502")
    HEAVY_RAIN,

    @SerializedName("511")
    FREEZING_RAIN,

    @SerializedName("520")
    LIGHT_SHOWER_RAIN,

    @SerializedName("521")
    SHOWER_RAIN,

    @SerializedName("522")
    HEAVY_SHOWER_RAIN,

    @SerializedName("600")
    LIGHT_SNOW,

    @SerializedName("601")
    SNOW,

    @SerializedName("602")
    HEAVY_SNOW,

    @SerializedName("610")
    MIX_SNOW_RAIN,

    @SerializedName("611")
    SLEET,

    @SerializedName("612")
    HEAVY_SLEET,

    @SerializedName("621")
    SNOW_SHOWER,

    @SerializedName("622")
    HEAVY_SNOW_SHOWER,

    @SerializedName("623")
    FLURRIES,

    @SerializedName("700")
    MIST,

    @SerializedName("711")
    SMOKE,

    @SerializedName("721")
    HAZE,

    @SerializedName("731")
    SAND_DUST,

    @SerializedName("741")
    FOG,

    @SerializedName("751")
    FREEZING_FOG,

    @SerializedName("800")
    CLEAR_SKY,

    @SerializedName("801")
    FEW_CLOUDS,

    @SerializedName("802")
    SCATTERED_CLOUDS,

    @SerializedName("803")
    BROKEN_CLOUDS,

    @SerializedName("804")
    OVERCAST_CLOUDS,

    @SerializedName("900")
    UNKNOWN;

    companion object {
        fun toIconId(
            code: WeatherCodeResponse,
            sunriseTime: String,
            sunsetTime: String
        ): Int {
            return when (code) {
                THUNDER_STORM_LIGHT_RAIN,
                THUNDER_STORM_RAIN,
                THUNDER_STORM_HEAVY_RAIN,
                THUNDER_STORM_LIGHT_DRIZZLE,
                THUNDER_STORM_DRIZZLE,
                THUNDER_STORM_HEAVY_DRIZZLE,
                THUNDER_STORM_HAIL,
                LIGHT_DRIZZLE,
                DRIZZLE,
                HEAVY_DRIZZLE
                -> drawable.ic_weather_thunder_storm
                LIGHT_RAIN,
                LIGHT_SHOWER_RAIN
                -> drawable.ic_weather_light_rain
                MODERATE_RAIN,
                SHOWER_RAIN
                -> drawable.ic_weather_moderate_rain
                HEAVY_RAIN,
                HEAVY_SHOWER_RAIN
                -> drawable.ic_weather_heavy_rain
                LIGHT_SNOW -> drawable.ic_weather_light_snow
                SNOW_SHOWER,
                SNOW
                -> drawable.ic_weather_snow
                FLURRIES,
                HEAVY_SNOW_SHOWER,
                HEAVY_SNOW
                -> drawable.ic_weather_heavy_snow
                MIST,
                SMOKE,
                HAZE,
                SAND_DUST,
                FOG,
                FREEZING_FOG
                -> drawable.ic_weather_fog
                FREEZING_RAIN,
                MIX_SNOW_RAIN
                -> drawable.ic_weather_snow_rain
                SLEET,
                HEAVY_SLEET
                -> drawable.ic_weather_sleet
                CLEAR_SKY -> {
                    if (isDaytime(sunriseTime, sunsetTime)) {
                        drawable.ic_weather_clear_sky_day
                    } else {
                        drawable.ic_weather_clear_sky_night
                    }
                }
                FEW_CLOUDS,
                SCATTERED_CLOUDS,
                BROKEN_CLOUDS
                -> {
                    if (isDaytime(sunriseTime, sunsetTime)) {
                        drawable.ic_weather_few_clouds_day
                    } else {
                        drawable.ic_weather_few_clouds_night
                    }
                }
                OVERCAST_CLOUDS -> drawable.ic_weather_overcast_clouds
                else -> drawable.ic_weather_overcast_clouds
            }
        }

        private fun isDaytime(
            sunriseTime: String,
            sunsetTime: String
        ): Boolean {
            val sunrise = Calendar.getInstance()
            sunrise.set(Calendar.HOUR_OF_DAY, sunriseTime.split(":")[0].toInt())
            sunrise.set(Calendar.MINUTE, sunriseTime.split(":")[1].toInt())

            val sunset = Calendar.getInstance()
            sunset.set(Calendar.HOUR_OF_DAY, sunsetTime.split(":")[0].toInt())
            sunset.set(Calendar.MINUTE, sunsetTime.split(":")[1].toInt())

            val currentTime = Calendar.getInstance()

            return currentTime.after(sunrise) && currentTime.before(sunset)
        }
    }

}