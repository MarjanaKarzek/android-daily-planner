package com.karzek.authorization.domain

import com.karzek.authorization.domain.IUpdateToken.Input
import com.karzek.authorization.domain.IUpdateToken.Output
import com.karzek.authorization.domain.token.model.Token
import com.karzek.core.domain.BaseSingleUseCase
import com.karzek.core.domain.BaseUseCase

interface IUpdateToken : BaseSingleUseCase<Input, Output> {

    data class Input(
        val type: Token,
        val value: String
    ) : BaseUseCase.Input

    sealed class Output : BaseUseCase.Output {
        object Success : Output()
        object ErrorUnknown : Output()
    }

}