package com.karzek.planner

import android.os.Bundle
import com.karzek.core.ui.base.BaseActivity
import com.karzek.core.util.replaceFragment
import com.karzek.daily.ui.DailyFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDaily()
    }

    private fun showDaily() {
        replaceFragment(DailyFragment.newInstance())
    }

}