package com.karzek.daily.domain.todo.repository

import com.karzek.daily.domain.todo.model.ToDo
import io.reactivex.Single
import java.util.Date

interface IToDoRepository {
    fun getToDosByDate(date: Date): Single<List<ToDo>>
}