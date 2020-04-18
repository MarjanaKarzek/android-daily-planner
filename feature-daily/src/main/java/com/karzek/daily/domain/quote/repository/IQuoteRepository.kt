package com.karzek.daily.domain.quote.repository

import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.Single

interface IQuoteRepository {
    fun getQuoteOfTheDay(): Single<Quote>
}