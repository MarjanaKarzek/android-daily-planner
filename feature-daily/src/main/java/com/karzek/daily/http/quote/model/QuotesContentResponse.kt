package com.karzek.daily.http.quote.model

import com.google.gson.annotations.SerializedName

data class QuotesContentResponse(
    @SerializedName("contents") val content: QuotesResponse
)