package com.karzek.localization.di

import com.karzek.localization.domain.location.ILocationProvider
import com.karzek.localization.domain.location.LocationProvider
import dagger.Binds
import dagger.Module

@Module
interface LocationModule {

    @Binds
    fun bindLocationProvider(locationProvider: LocationProvider): ILocationProvider
}