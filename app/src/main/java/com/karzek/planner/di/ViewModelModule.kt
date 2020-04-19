package com.karzek.planner.di

import androidx.lifecycle.ViewModelProvider
import com.karzek.core.di.DaggerViewModelFactory
import com.karzek.daily.di.DailyViewModels
import com.karzek.debug.di.DebugViewModels
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DailyViewModels::class,
        DebugViewModels::class
    ]
)
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}