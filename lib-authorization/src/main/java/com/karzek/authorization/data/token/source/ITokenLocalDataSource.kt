package com.karzek.authorization.data.token.source

import com.karzek.authorization.domain.token.model.Token
import io.reactivex.Completable

interface ITokenLocalDataSource {

    fun getToken(token: Token): String?

    fun updateToken(
        type: Token,
        value: String
    ): Completable

}