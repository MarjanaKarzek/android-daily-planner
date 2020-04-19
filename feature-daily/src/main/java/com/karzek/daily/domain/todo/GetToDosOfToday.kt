package com.karzek.daily.domain.todo

import com.karzek.daily.domain.todo.IGetToDosOfToday.Input
import com.karzek.daily.domain.todo.IGetToDosOfToday.Output
import com.karzek.daily.domain.todo.IGetToDosOfToday.Output.ErrorUnknown
import com.karzek.daily.domain.todo.IGetToDosOfToday.Output.Success
import com.karzek.daily.domain.todo.repository.IToDoRepository
import io.reactivex.Single
import java.util.Date
import javax.inject.Inject

class GetToDosOfToday @Inject constructor(
    private val toDoRepository: IToDoRepository
) : IGetToDosOfToday {

    override fun execute(input: Input): Single<Output> {
        return toDoRepository.getToDosByDate(Date())
            .map {
                Success(it) as Output
            }
            .onErrorReturn {
                ErrorUnknown
            }
    }

}