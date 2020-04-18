package com.karzek.daily.http.quote.model

import com.google.gson.annotations.SerializedName

data class QuotesResponse(
    @SerializedName("quotes") val quotes: List<QuoteResponse>
)