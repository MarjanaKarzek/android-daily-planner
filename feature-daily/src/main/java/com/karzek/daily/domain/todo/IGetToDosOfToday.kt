package com.karzek.daily.domain.todo

import com.karzek.core.domain.BaseSingleUseCase
import com.karzek.core.domain.BaseUseCase
import com.karzek.daily.domain.todo.IGetToDosOfToday.Input
import com.karzek.daily.domain.todo.IGetToDosOfToday.Output
import com.karzek.daily.domain.todo.model.ToDo

interface IGetToDosOfToday : BaseSingleUseCase<Input, Output> {

    object Input : BaseUseCase.Input

    sealed class Output : BaseUseCase.Output {
        data class Success(val toDos: List<ToDo>) : Output()
        object ErrorUnknown : Output()
    }

}