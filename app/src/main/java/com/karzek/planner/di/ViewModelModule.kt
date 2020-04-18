package com.karzek.planner.di

import androidx.lifecycle.ViewModelProvider
import com.karzek.core.di.DaggerViewModelFactory
import com.karzek.daily.di.DailyViewModels
import dagger.Binds
import dagger.Module

@Module(
    includes = [DailyViewModels::class]
)
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}