package com.karzek.daily.data.todo.source

import com.karzek.daily.domain.todo.model.ToDo
import io.reactivex.Single
import java.util.Date
import javax.inject.Inject

class ToDoLocalDataSource @Inject constructor() : IToDoLocalDataSource {

    override fun getToDosByDate(date: Date): Single<List<ToDo>> {
        //todo implement actual database
        return Single.just(
            listOf(
                ToDo("Tidy up the flat", Date()),
                ToDo("Get groceries", Date()),
                ToDo("Call landlord", Date()),
                ToDo("Have a virtual coffee with Nina", Date()),
                ToDo("Watch a movie with Kyra", Date()),
                ToDo("Eat cookies", Date()),
                ToDo("Get a birthday present for Fabian", Date()),
                ToDo("Walk the dog", Date()),
                ToDo("Implement CollapsingToolbarLayout", Date()),
                ToDo("Read a chapter", Date()),
                ToDo("Practice Spanish", Date())
            )
        )
    }

}