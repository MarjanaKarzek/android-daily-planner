package com.karzek.authorization.domain.token

import com.karzek.authorization.domain.token.model.Token
import io.reactivex.Completable

interface ITokenRepository {

    fun getToken(token: Token): String?

    fun updateToken(
        type: Token,
        value: String
    ): Completable

}