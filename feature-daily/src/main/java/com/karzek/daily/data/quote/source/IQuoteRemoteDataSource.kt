package com.karzek.daily.data.quote.source

import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.Single

interface IQuoteRemoteDataSource {
    fun getQuoteOfTheDay(): Single<Quote>
}