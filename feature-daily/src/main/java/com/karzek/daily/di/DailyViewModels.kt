package com.karzek.daily.di

import androidx.lifecycle.ViewModel
import com.karzek.core.di.ViewModelKey
import com.karzek.daily.ui.DailyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DailyViewModels {
    @Binds
    @IntoMap
    @ViewModelKey(DailyViewModel::class)
    fun bindDailyViewModel(viewModel: DailyViewModel): ViewModel
}