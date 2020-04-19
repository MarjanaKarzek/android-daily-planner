package com.karzek.daily.data.weather.source

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import com.karzek.daily.domain.weather.model.Weather
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import java.util.Date
import javax.inject.Inject

@SuppressLint("ApplySharedPref")
class WeatherLocalDataSource @Inject constructor(
    private val cache: SharedPreferences,
    private val gson: Gson
) : IWeatherLocalDataSource {

    override fun getCurrentWeather(location: Location): Maybe<Weather> {
        return isCacheValid(location)
            .filter { it }
            .flatMap {
                readCurrentWeather(location)
            }
    }

    private fun readCurrentWeather(location: Location): Maybe<Weather> {
        return try {
            Maybe.fromCallable {
                val weatherRaw = cache.getString("$KEY_CURRENT_WEATHER-${location.latitude}-${location.longitude}", null)
                gson.fromJson(weatherRaw, Weather::class.java)
            }
        } catch (e: Exception) {
            Maybe.empty()
        }
    }

    override fun updateCurrentWeather(
        location: Location,
        weather: Weather
    ): Completable {
        return Completable.fromCallable {
            cache.edit().putString("$KEY_CURRENT_WEATHER-${location.latitude}-${location.longitude}", gson.toJson(weather)).commit()
            cache.edit().putLong("$KEY_CURRENT_WEATHER_TIMESTAMP-${location.latitude}-${location.longitude}", Date().time).commit()
        }
    }

    private fun isCacheValid(location: Location): Single<Boolean> {
        return Single.fromCallable {
            val timestamp = cache.getLong("$KEY_CURRENT_WEATHER_TIMESTAMP-${location.latitude}-${location.longitude}", CACHE_TIMEOUT)
            timestamp < CACHE_TIMEOUT
        }
    }

    companion object {
        private const val KEY_CURRENT_WEATHER = "KEY_CURRENT_WEATHER"
        private const val KEY_CURRENT_WEATHER_TIMESTAMP = "KEY_CURRENT_WEATHER_TIMESTAMP"

        private const val CACHE_TIMEOUT = 3600000L
    }

}