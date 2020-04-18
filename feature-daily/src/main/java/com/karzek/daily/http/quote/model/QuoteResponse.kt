package com.karzek.daily.http.quote.model

import com.google.gson.annotations.SerializedName
import com.karzek.daily.domain.quote.model.Quote

data class QuoteResponse(
    @SerializedName("id") val id: String,
    @SerializedName("quote") val text: String,
    @SerializedName("author") val author: String,
    @SerializedName("date") val date: String
) {
    fun toModel() = Quote(id, text, author, date)
}