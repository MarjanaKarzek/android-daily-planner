package com.karzek.daily.domain.weather.model

data class Weather(
    val code: String,
    val icon: String,
    val temperature: Double
)