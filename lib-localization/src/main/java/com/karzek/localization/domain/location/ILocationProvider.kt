package com.karzek.localization.domain.location

import com.karzek.localization.domain.location.model.Location
import io.reactivex.Single

interface ILocationProvider {
    fun getCurrentLocation(): Single<Location>
}