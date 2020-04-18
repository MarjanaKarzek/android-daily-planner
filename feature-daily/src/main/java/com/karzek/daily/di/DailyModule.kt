package com.karzek.daily.di

import dagger.Module

@Module(includes = [
    QuoteModule::class
])
interface DailyModule