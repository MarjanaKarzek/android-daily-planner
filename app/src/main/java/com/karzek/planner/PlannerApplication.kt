package com.karzek.planner

import com.karzek.planner.di.AppComponent
import dagger.Dagger
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class PlannerApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        Dagger.factory(AppComponent.Factory::class.java).create(this)
}