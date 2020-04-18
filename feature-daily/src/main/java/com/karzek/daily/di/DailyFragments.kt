package com.karzek.daily.di

import com.karzek.core.di.FragmentScope
import com.karzek.daily.ui.DailyFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DailyFragments {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideDailyFragment(): DailyFragment
}