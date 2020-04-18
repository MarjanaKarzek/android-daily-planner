package com.karzek.planner.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.karzek.planner.PlannerApplication
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideApplicationContext(application: PlannerApplication): Context = application.applicationContext

    @Provides fun provideAppSharedPreferences(context: Context) : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)
    }

    private const val SHARED_PREFERENCES_NAME = "planner_shared_preferences"
}