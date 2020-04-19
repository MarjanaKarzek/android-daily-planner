package com.karzek.planner.di

import com.karzek.daily.di.DailyFragments
import com.karzek.debug.di.DebugFragments
import dagger.Module

@Module(
    includes = [
        DailyFragments::class,
        DebugFragments::class
    ]
)
interface FragmentsModule