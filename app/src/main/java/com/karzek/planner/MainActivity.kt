package com.karzek.planner

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.karzek.core.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment_host).navigateUp()
    }

    private fun setupNavigation() {
        val navController = Navigation.findNavController(findViewById(R.id.fragment_host))
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

}