package com.karzek.debug.di

import com.karzek.core.di.FragmentScope
import com.karzek.debug.ui.DebugFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DebugFragments {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideDebugFragment(): DebugFragment
}