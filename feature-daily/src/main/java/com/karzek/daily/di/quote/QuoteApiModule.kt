package com.karzek.daily.di.quote

import com.karzek.core.di.NetworkingModule
import com.karzek.daily.http.quote.IQuoteApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkingModule::class])
class QuoteApiModule {

    @Singleton
    @Provides
    fun providesQuotesApiService(
        okHttpClientBuilder: OkHttpClient.Builder
    ): IQuoteApiService {
        return Retrofit.Builder()
            .baseUrl(QUOTE_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(IQuoteApiService::class.java)
    }

    companion object {
        private const val QUOTE_BASE_URL = "https://quotes.rest/"
    }

}