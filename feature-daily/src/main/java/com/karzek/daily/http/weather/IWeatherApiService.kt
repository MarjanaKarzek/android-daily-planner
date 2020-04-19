package com.karzek.daily.http.weather

import com.karzek.daily.http.weather.model.WeatherDataListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApiService {

    @GET("/current")
    fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("long") longitude: Double
    ): Single<WeatherDataListResponse>

}