package com.karzek.planner.di

import com.karzek.core.di.ActivityScope
import com.karzek.planner.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector(modules = [
        FragmentsModule::class
    ])
    @ActivityScope
    fun provideMainActivity(): MainActivity
}