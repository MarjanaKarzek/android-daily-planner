package com.karzek.core.ui.base

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.karzek.core.util.nonConcurrentLazy
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layoutRes: Int) : DaggerFragment(layoutRes) {

    abstract fun getTagForStack() : String

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected inline fun <reified T : ViewModel> bindViewModel(): Lazy<T> =
        nonConcurrentLazy {
            ViewModelProvider(this, viewModelFactory).get(T::class.java)
        }

    protected inline fun <reified  T : ViewModel> bindParentViewModel(): Lazy<T> =
        nonConcurrentLazy {
            ViewModelProvider(requireParentFragment(), viewModelFactory).get(T::class.java)
        }

    protected inline fun <reified T : ViewModel> bindActivityViewModel(): Lazy<T> =
        nonConcurrentLazy {
            ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)
        }

}