package com.karzek.debug.di

import androidx.lifecycle.ViewModel
import com.karzek.core.di.ViewModelKey
import com.karzek.debug.ui.DebugViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DebugViewModels {
    @Binds
    @IntoMap
    @ViewModelKey(DebugViewModel::class)
    fun bindDailyViewModel(viewModel: DebugViewModel): ViewModel
}