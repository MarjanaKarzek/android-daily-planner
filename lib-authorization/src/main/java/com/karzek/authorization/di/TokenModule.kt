package com.karzek.authorization.di

import com.karzek.authorization.data.token.TokenRepository
import com.karzek.authorization.data.token.source.ITokenLocalDataSource
import com.karzek.authorization.data.token.source.TokenLocalDataSource
import com.karzek.authorization.domain.IUpdateToken
import com.karzek.authorization.domain.UpdateToken
import com.karzek.authorization.domain.token.ITokenRepository
import dagger.Binds
import dagger.Module

@Module
interface TokenModule {

    @Binds
    fun bindTokenLocalDataSource(localDataSource: TokenLocalDataSource): ITokenLocalDataSource

    @Binds
    fun bindTokenRepository(tokenRepository: TokenRepository): ITokenRepository

    @Binds
    fun bindUpdateTokenUseCase(updateToken: UpdateToken): IUpdateToken

}