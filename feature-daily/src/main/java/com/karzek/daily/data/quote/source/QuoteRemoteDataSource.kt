package com.karzek.daily.data.quote.source

import com.karzek.daily.domain.quote.model.Quote
import com.karzek.daily.http.quote.IQuoteApiService
import io.reactivex.Single
import javax.inject.Inject

class QuoteRemoteDataSource @Inject constructor(
    private val apiService: IQuoteApiService
) : IQuoteRemoteDataSource {

    override fun getQuoteOfTheDay(): Single<Quote> {
        return apiService.getQuoteOfTheDay()
            .map {
                it.content.quotes[0].toModel()
            }
    }

}