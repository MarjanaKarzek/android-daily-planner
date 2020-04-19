package com.karzek.authorization.domain

import com.karzek.authorization.domain.IUpdateToken.Input
import com.karzek.authorization.domain.IUpdateToken.Output
import com.karzek.authorization.domain.IUpdateToken.Output.ErrorUnknown
import com.karzek.authorization.domain.IUpdateToken.Output.Success
import com.karzek.authorization.domain.token.ITokenRepository
import io.reactivex.Single
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val tokenRepository: ITokenRepository
) : IUpdateToken {

    override fun execute(input: Input): Single<Output> {
        return tokenRepository.updateToken(input.type, input.value)
            .toSingleDefault(Success as Output)
            .onErrorReturn {
                ErrorUnknown
            }
    }

}