package com.karzek.planner.di

import com.karzek.daily.di.DailyFragments
import dagger.Module

@Module(includes = [DailyFragments::class])
interface FragmentsModule