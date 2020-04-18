package com.karzek.daily.domain.quote.model

data class Quote(
    val id: String,
    val text: String,
    val author: String,
    val date: String
)