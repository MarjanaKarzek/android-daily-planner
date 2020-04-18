package com.karzek.daily.ui

import com.karzek.core.ui.base.BaseFragment
import com.karzek.daily.R.layout

class DailyFragment : BaseFragment(layout.fragment_daily) {

    private val viewModel: DailyViewModel by bindViewModel()

    override fun getTagForStack() = DailyFragment::class.java.toString()

    companion object {
        fun newInstance() = DailyFragment()
    }
}