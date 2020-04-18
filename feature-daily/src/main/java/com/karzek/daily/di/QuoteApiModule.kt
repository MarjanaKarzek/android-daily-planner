package com.karzek.daily.di

import com.karzek.core.di.NetworkingModule
import com.karzek.daily.http.quote.QuoteApiService
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
        okHttpClient: OkHttpClient
    ): QuoteApiService {
        return Retrofit.Builder()
            .baseUrl(QUOTE_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(QuoteApiService::class.java)
    }

    companion object {
        private const val QUOTE_BASE_URL = "https://quotes.rest/"
    }

}