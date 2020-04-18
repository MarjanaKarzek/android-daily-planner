package com.karzek.daily.di

import com.karzek.daily.data.quote.QuoteRepository
import com.karzek.daily.data.quote.source.QuoteDataSource
import com.karzek.daily.data.quote.source.QuoteRemoteDataSource
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
    fun bindQuoteRemoteDataSource(remoteDataSource: QuoteRemoteDataSource) : QuoteDataSource

    @Binds
    fun bindQuoteRepository(quoteRepository: QuoteRepository) : IQuoteRepository

    @Binds
    fun bindGetQuoteOfTheDayUseCase(getQuoteOfTheDay: GetQuoteOfTheDay) : IGetQuoteOfTheDay

}