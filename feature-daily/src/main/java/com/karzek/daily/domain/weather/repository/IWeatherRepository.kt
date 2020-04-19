package com.karzek.daily.domain.weather.repository

import com.karzek.daily.domain.weather.model.Weather
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single

interface IWeatherRepository {
    fun getCurrentWeather(location: Location): Single<Weather>
}