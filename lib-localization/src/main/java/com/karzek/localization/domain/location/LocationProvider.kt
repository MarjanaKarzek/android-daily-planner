package com.karzek.localization.domain.location

import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single
import javax.inject.Inject

class LocationProvider @Inject constructor() : ILocationProvider {
    override fun getCurrentLocation(): Single<Location> {
        //todo get actual location with FusedLocationProvider
        return Single.just(Location(52.520008, 13.404954))
    }
}