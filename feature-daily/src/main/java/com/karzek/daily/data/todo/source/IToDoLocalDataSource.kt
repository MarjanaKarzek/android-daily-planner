package com.karzek.daily.data.todo.source

import com.karzek.daily.domain.todo.model.ToDo
import io.reactivex.Single
import java.util.Date

interface IToDoLocalDataSource {

    fun getToDosByDate(date: Date): Single<List<ToDo>>

}
