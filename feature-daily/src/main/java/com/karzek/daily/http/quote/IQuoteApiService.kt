package com.karzek.daily.http.quote

import com.karzek.daily.http.quote.model.QuotesContentResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IQuoteApiService {

    @GET("/qod")
    fun getQuoteOfTheDay(@Query("category") category: String? = "inspire"): Single<QuotesContentResponse>

}