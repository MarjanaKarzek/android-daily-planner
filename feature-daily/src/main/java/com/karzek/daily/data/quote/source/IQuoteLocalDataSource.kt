package com.karzek.daily.data.quote.source

import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.Completable
import io.reactivex.Maybe

interface IQuoteLocalDataSource {
    fun updateQuoteOfTheDay(quote: Quote): Completable
    fun deleteQuoteOfTheDay(): Completable
    fun getQuoteOfTheDay(): Maybe<Quote>
}