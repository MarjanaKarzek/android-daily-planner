package com.karzek.daily.http.weather

import com.karzek.daily.http.weather.model.WeatherDataListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApiService {

    @GET("/v2.0/current")
    fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): Single<WeatherDataListResponse>

}