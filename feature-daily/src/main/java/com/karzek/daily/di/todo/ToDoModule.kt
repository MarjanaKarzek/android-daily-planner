package com.karzek.daily.di.todo

import com.karzek.daily.data.todo.ToDoRepository
import com.karzek.daily.data.todo.source.IToDoLocalDataSource
import com.karzek.daily.data.todo.source.ToDoLocalDataSource
import com.karzek.daily.domain.todo.GetToDosOfToday
import com.karzek.daily.domain.todo.IGetToDosOfToday
import com.karzek.daily.domain.todo.repository.IToDoRepository
import dagger.Binds
import dagger.Module

@Module
interface ToDoModule {

    @Binds
    fun provideToDoLocalDataSource(toDoLocalDataSource: ToDoLocalDataSource): IToDoLocalDataSource

    @Binds
    fun bindToDoRepository(toDoRepository: ToDoRepository): IToDoRepository

    @Binds
    fun bindGetToDosOfTodayUseCase(getToDosOfToday: GetToDosOfToday): IGetToDosOfToday

}