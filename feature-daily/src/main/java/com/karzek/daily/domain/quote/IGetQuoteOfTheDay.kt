package com.karzek.daily.domain.quote

import com.karzek.core.domain.BaseSingleUseCase
import com.karzek.core.domain.BaseUseCase
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Input
import com.karzek.daily.domain.quote.IGetQuoteOfTheDay.Output
import com.karzek.daily.domain.quote.model.Quote

interface IGetQuoteOfTheDay : BaseSingleUseCase<Input, Output> {

    object Input : BaseUseCase.Input

    sealed class Output : BaseUseCase.Output {
        data class Success(val quote: Quote) : Output()
        object ErrorUnknown : Output()
    }

}