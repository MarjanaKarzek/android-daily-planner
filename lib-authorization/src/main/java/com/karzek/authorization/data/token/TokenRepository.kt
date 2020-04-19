package com.karzek.authorization.data.token

import com.karzek.authorization.data.token.source.ITokenLocalDataSource
import com.karzek.authorization.domain.token.ITokenRepository
import com.karzek.authorization.domain.token.model.Token
import io.reactivex.Completable
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val localDataSource: ITokenLocalDataSource
) : ITokenRepository {

    override fun getToken(token: Token): String? {
        return localDataSource.getToken(token)
    }

    override fun updateToken(
        type: Token,
        value: String
    ): Completable {
        return localDataSource.updateToken(type, value)
    }

}