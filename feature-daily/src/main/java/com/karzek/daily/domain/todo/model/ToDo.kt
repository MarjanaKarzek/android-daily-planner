package com.karzek.daily.domain.todo.model

import java.util.Date

data class ToDo(
    val description: String,
    val dueDate: Date
)