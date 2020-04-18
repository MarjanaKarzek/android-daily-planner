package com.karzek.daily.data.quote.source

import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.Single

interface QuoteDataSource {
    fun getQuoteOfTheDay(): Single<Quote>
}