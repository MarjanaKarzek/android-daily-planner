package com.karzek.daily.ui

import com.karzek.core.ui.base.BaseViewModel
import com.karzek.core.ui.error.UIError.Unknown
import com.karzek.core.util.doOnIoObserveOnMain
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Input
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Output.Success
import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class DailyViewModel @Inject constructor(
    private val getQuoteOfTheDay: IGetQuoteOfTheDay
) : BaseViewModel() {

    val quote = BehaviorSubject.create<Quote>()

    fun getQuoteOfTheDay() {
        getQuoteOfTheDay.execute(Input)
            .doOnIoObserveOnMain()
            .subscribeBy {
                when (it) {
                    is Success -> quote.onNext(it.quote)
                    else -> error.onNext(Unknown)
                }
            }
            .addTo(compositeDisposable)
    }

}