package com.karzek.daily.ui

import com.karzek.core.ui.base.BaseViewModel
import com.karzek.core.ui.error.UIError.Unauthorised
import com.karzek.core.ui.error.UIError.Unknown
import com.karzek.core.util.doOnIoObserveOnMain
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay
import com.karzek.daily.domain.quote.model.Quote
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather
import com.karzek.daily.domain.weather.IGetCurrentLocalWeather.Output.ErrorUnauthorised
import com.karzek.daily.domain.weather.model.Weather
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class DailyViewModel @Inject constructor(
    private val getQuoteOfTheDay: IGetQuoteOfTheDay,
    private val getCurrentLocalWeather: IGetCurrentLocalWeather
) : BaseViewModel() {

    val quote = BehaviorSubject.create<Quote>()
    val currentWeather = BehaviorSubject.create<Weather>()

    fun getQuoteOfTheDay() {
        getQuoteOfTheDay.execute(IGetQuoteOfTheDay.Input)
            .doOnIoObserveOnMain()
            .subscribeBy {
                when (it) {
                    is IGetQuoteOfTheDay.Output.Success -> quote.onNext(it.quote)
                    else -> error.onNext(Unknown)
                }
            }
            .addTo(compositeDisposable)
    }

    fun getCurrentWeather() {
        getCurrentLocalWeather.execute(IGetCurrentLocalWeather.Input)
            .doOnIoObserveOnMain()
            .subscribeBy {
                when (it) {
                    is IGetCurrentLocalWeather.Output.Success -> currentWeather.onNext(it.weather)
                    is ErrorUnauthorised -> error.onNext(Unauthorised)
                    else -> error.onNext(Unknown)
                }
            }
            .addTo(compositeDisposable)
    }

}