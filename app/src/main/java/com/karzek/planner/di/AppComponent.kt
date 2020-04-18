package com.karzek.planner.di

import com.karzek.core.di.CoreModule
import com.karzek.daily.di.DailyModule
import com.karzek.planner.PlannerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        CoreModule::class,
        ViewModelModule::class,
        DailyModule::class
    ]
)
interface AppComponent : AndroidInjector<PlannerApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<PlannerApplication>
}