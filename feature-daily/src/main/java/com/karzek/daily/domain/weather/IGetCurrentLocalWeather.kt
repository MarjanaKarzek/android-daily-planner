package com.karzek.daily.domain.weather

import com.karzek.core.domain.BaseSingleUseCase
import com.karzek.core.domain.BaseUseCase
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Input
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output
import com.karzek.daily.domain.weather.model.Weather

interface IGetCurrentLocalWeather : BaseSingleUseCase<Input, Output> {

    object Input : BaseUseCase.Input

    sealed class Output : BaseUseCase.Output {
        data class Success(val weather: Weather) : Output()
        object ErrorUnauthorised : Output()
        object ErrorUnknown : Output()
    }

}