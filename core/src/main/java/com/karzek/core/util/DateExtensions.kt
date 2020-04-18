package com.karzek.core.util

import android.icu.text.SimpleDateFormat
import java.text.DateFormat
import java.util.Date

fun Date.toISO8601u2004(): String {
    return SimpleDateFormat("yyyy-MM-dd").format(this)
}

fun String.toDate(): Date? {
    return DateFormat.getDateInstance().parse(this)
}