package com.karzek.daily.di.weather

import com.karzek.authorization.di.SessionModule
import com.karzek.daily.data.weather.WeatherRepository
import com.karzek.daily.data.weather.source.IWeatherLocalDataSource
import com.karzek.daily.data.weather.source.IWeatherRemoteDataSource
import com.karzek.daily.data.weather.source.WeatherLocalDataSource
import com.karzek.daily.data.weather.source.WeatherRemoteDataSource
import com.karzek.daily.domain.weather.GetCurrentLocalWeather
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather
import com.karzek.daily.domain.weather.repository.IWeatherRepository
import com.karzek.localization.di.LocationModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        WeatherApiModule::class,
        LocationModule::class,
        SessionModule::class
    ]
)
interface WeatherModule {

    @Binds
    fun bindWeatherRemoteDataSource(remoteDataSource: WeatherRemoteDataSource): IWeatherRemoteDataSource

    @Binds
    fun provideWeatherLocalDataSource(localDataSource: WeatherLocalDataSource): IWeatherLocalDataSource

    @Binds
    fun bindWeatherRepository(weatherRepository: WeatherRepository): IWeatherRepository

    @Binds
    fun bindGetCurrentLocalWeatherUseCase(getCurrentLocalWeather: GetCurrentLocalWeather): IGetCurrentLocalWeather

}