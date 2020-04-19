package com.karzek.daily.di.quote

import com.karzek.daily.data.quote.QuoteRepository
import com.karzek.daily.data.quote.source.IQuoteLocalDataSource
import com.karzek.daily.data.quote.source.IQuoteRemoteDataSource
import com.karzek.daily.data.quote.source.QuoteLocalDataSource
import com.karzek.daily.data.quote.source.QuoteRemoteDataSource
import com.karzek.daily.di.quote.QuoteApiModule
import com.karzek.daily.domain.quote.GetQuoteOfTheDay
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay
import com.karzek.daily.domain.quote.repository.IQuoteRepository
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        QuoteApiModule::class
    ]
)
interface QuoteModule {

    @Binds
    fun bindQuoteRemoteDataSource(remoteDataSource: QuoteRemoteDataSource): IQuoteRemoteDataSource

    @Binds
    fun provideQuoteLocalDataSource(quoteLocalDataSource: QuoteLocalDataSource): IQuoteLocalDataSource

    @Binds
    fun bindQuoteRepository(quoteRepository: QuoteRepository): IQuoteRepository

    @Binds
    fun bindGetQuoteOfTheDayUseCase(getQuoteOfTheDay: GetQuoteOfTheDay): IGetQuoteOfTheDay

}