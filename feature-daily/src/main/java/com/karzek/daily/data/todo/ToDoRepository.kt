package com.karzek.daily.data.todo

import com.karzek.daily.data.todo.source.IToDoLocalDataSource
import com.karzek.daily.domain.todo.model.ToDo
import com.karzek.daily.domain.todo.repository.IToDoRepository
import io.reactivex.Single
import java.util.Date
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val localDataSource: IToDoLocalDataSource
) : IToDoRepository {

    override fun getToDosByDate(date: Date): Single<List<ToDo>> {
        return localDataSource.getToDosByDate(date)
    }

}