package com.karzek.daily.data.weather.source

import com.karzek.daily.domain.weather.model.Weather
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Completable
import io.reactivex.Maybe

interface IWeatherLocalDataSource {

    fun getCurrentWeather(location: Location): Maybe<Weather>

    fun updateCurrentWeather(
        location: Location,
        weather: Weather
    ): Completable

}
