package com.karzek.daily.data.weather.source

import com.karzek.daily.domain.weather.model.Weather
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single

interface IWeatherRemoteDataSource {

    fun getCurrentWeather(location: Location): Single<Weather>

}
