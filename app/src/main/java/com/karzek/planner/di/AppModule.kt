package com.karzek.planner.di

import android.content.Context
import com.karzek.planner.PlannerApplication
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @Provides fun provideApplicationContext(application: PlannerApplication): Context = application.applicationContext
}