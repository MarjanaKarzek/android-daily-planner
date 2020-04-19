package com.karzek.daily.data.quote.source

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import com.karzek.core.util.toISO8601u2004
import com.karzek.daily.domain.quote.model.Quote
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import java.util.Date
import javax.inject.Inject

@SuppressLint("ApplySharedPref")
class QuoteLocalDataSource @Inject constructor(
    private val gson: Gson,
    private val cache: SharedPreferences
) : IQuoteLocalDataSource {

    override fun getQuoteOfTheDay(): Maybe<Quote> {
        return isCacheValid()
            .filter { it }
            .flatMap {
                readQuoteOfTheDay()
            }
    }

    private fun readQuoteOfTheDay(): Maybe<Quote> {
        return try {
            Maybe.fromCallable {
                val quoteRaw = cache.getString(KEY_QUOTE_OF_THE_DAY, null)
                gson.fromJson(quoteRaw, Quote::class.java)
            }
        } catch (e: Exception) {
            Maybe.empty()
        }
    }

    override fun updateQuoteOfTheDay(quote: Quote): Completable {
        return Completable.fromCallable {
            cache.edit().putString(KEY_QUOTE_OF_THE_DAY, gson.toJson(quote)).commit()
            cache.edit().putString(KEY_QUOTE_OF_THE_DAY_TIMESTAMP, quote.date).commit()
        }
    }

    override fun deleteQuoteOfTheDay(): Completable {
        return Completable.fromCallable {
            cache.edit().putString(KEY_QUOTE_OF_THE_DAY, null).commit()
            cache.edit().putString(KEY_QUOTE_OF_THE_DAY_TIMESTAMP, null).commit()
        }
    }

    private fun isCacheValid(): Single<Boolean> {
        return Single.fromCallable {
            var isValid = false
            val timestamp = cache.getString(KEY_QUOTE_OF_THE_DAY_TIMESTAMP, null)
            timestamp?.run {
                isValid = this == Date().toISO8601u2004()
            }
            isValid
        }
    }

    companion object {
        private const val KEY_QUOTE_OF_THE_DAY = "KEY_QUOTE_OF_THE_DAY"
        private const val KEY_QUOTE_OF_THE_DAY_TIMESTAMP = "KEY_QUOTE_OF_THE_DAY_TIMESTAMP"
    }

}