package com.karzek.daily.domain.weather

import com.karzek.core.util.isForbidden
import com.karzek.core.util.isUnauthorised
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Input
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output.ErrorUnauthorised
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output.ErrorUnknown
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output.Success
import com.karzek.daily.domain.weather.repository.IWeatherRepository
import com.karzek.localization.domain.location.ILocationProvider
import io.reactivex.Single
import javax.inject.Inject

class GetCurrentLocalWeather @Inject constructor(
    private val locationProvider: ILocationProvider,
    private val weatherRepository: IWeatherRepository
) : IGetCurrentLocalWeather {

    override fun execute(input: Input): Single<Output> {
        return locationProvider.getCurrentLocation()
            .flatMap {
                weatherRepository.getCurrentWeather(it)
            }
            .map {
                Success(it) as Output
            }
            .onErrorReturn {
                when {
                    it.isForbidden() -> ErrorUnauthorised
                    it.isUnauthorised() -> ErrorUnauthorised
                    else -> ErrorUnknown
                }
            }
    }

}