package com.karzek.daily.domain.quote

import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Input
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Output
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Output.ErrorUnknown
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Output.Success
import com.karzek.daily.domain.quote.repository.IQuoteRepository
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class GetQuoteOfTheDay @Inject constructor(
    private val quoteRepository: IQuoteRepository
) : IGetQuoteOfTheDay {

    override fun execute(input: Input): Single<Output> {
        return quoteRepository.getQuoteOfTheDay()
            .map {
                Success(it) as Output
            }
            .onErrorReturn {
                Timber.e(it)
                ErrorUnknown
            }
    }

}