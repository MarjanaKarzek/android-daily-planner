package com.karzek.authorization.di

import com.karzek.authorization.domain.session.ISessionManager
import com.karzek.authorization.domain.session.SessionManager
import dagger.Binds
import dagger.Module

@Module(includes = [TokenModule::class])
interface SessionModule {

    @Binds
    fun bindSessionManager(sessionManager: SessionManager): ISessionManager

}