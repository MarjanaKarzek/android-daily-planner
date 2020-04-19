package com.karzek.daily.data.weather

import com.karzek.daily.data.weather.source.IWeatherLocalDataSource
import com.karzek.daily.data.weather.source.IWeatherRemoteDataSource
import com.karzek.daily.domain.weather.model.Weather
import com.karzek.daily.domain.weather.repository.IWeatherRepository
import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val remoteDataSource: IWeatherRemoteDataSource,
    private val localDataSource: IWeatherLocalDataSource
) : IWeatherRepository {

    override fun getCurrentWeather(location: Location): Single<Weather> {
        return localDataSource.getCurrentWeather(location)
            .switchIfEmpty(
                remoteDataSource.getCurrentWeather(location)
                    .flatMap {
                        localDataSource.updateCurrentWeather(location, it)
                            .andThen(Single.just(it))
                    }
            )
    }

}