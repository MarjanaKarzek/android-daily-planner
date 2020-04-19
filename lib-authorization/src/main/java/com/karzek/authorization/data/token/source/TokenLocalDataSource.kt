package com.karzek.authorization.data.token.source

import androidx.security.crypto.EncryptedSharedPreferences
import com.karzek.authorization.domain.token.model.Token
import io.reactivex.Completable
import javax.inject.Inject

class TokenLocalDataSource @Inject constructor(
    private val encryptedCache: EncryptedSharedPreferences
) : ITokenLocalDataSource {

    override fun getToken(token: Token): String? {
        return encryptedCache.getString("$KEY_TOKEN-${token.name}", null)
    }

    override fun updateToken(
        type: Token,
        value: String
    ): Completable {
        return Completable.fromCallable {
            encryptedCache.edit().putString("$KEY_TOKEN-${type.name}", value).commit()
        }
    }

    companion object {
        private const val KEY_TOKEN = "KEY_TOKEN"
    }

}