package com.karzek.daily.data.quote

import com.karzek.daily.data.quote.source.QuoteRemoteDataSource
import com.karzek.daily.domain.quote.model.Quote
import com.karzek.daily.domain.quote.repository.IQuoteRepository
import io.reactivex.Single
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val remoteDataSource: QuoteRemoteDataSource
) : IQuoteRepository {

    override fun getQuoteOfTheDay(): Single<Quote> {
        return remoteDataSource.getQuoteOfTheDay()
    }

}