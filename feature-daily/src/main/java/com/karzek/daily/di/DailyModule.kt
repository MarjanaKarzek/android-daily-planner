package com.karzek.daily.di

import com.karzek.daily.di.quote.QuoteModule
import com.karzek.daily.di.weather.WeatherModule
import dagger.Module

@Module(includes = [
    QuoteModule::class,
    WeatherModule::class
])
interface DailyModule