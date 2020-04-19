package com.karzek.debug.di

import com.karzek.authorization.di.TokenModule
import dagger.Module

@Module(includes = [TokenModule::class])
interface DebugModule