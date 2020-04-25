package com.karzek.daily.data.weather.source

import com.karzek.core.networking.exception.ManualUnauthorisedException
import com.karzek.core.networking.exception.ManualUnknownProblemException
import com.karzek.daily.domain.weather.model.Weather
import com.karzek.daily.http.weather.IWeatherApiService
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val apiService: IWeatherApiService
) : IWeatherRemoteDataSource {

    override fun getCurrentWeather(location: Location): Single<Weather> {
        return apiService.getCurrentWeather(location.latitude, location.longitude)
            .map {
                it.error?.run {
                    if (this.contains("API key is required")) {
                        throw ManualUnauthorisedException()
                    } else {
                        throw ManualUnknownProblemException()
                    }
                } ?: run {
                    it.data!![0].toModel()
                }
            }
    }

}