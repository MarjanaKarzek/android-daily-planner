package com.karzek.core.util

import com.karzek.core.networking.exception.ManualUnauthorisedException
import retrofit2.HttpException

fun Throwable.isUnauthorised() = this is HttpException && this.code() == HttpCodes.UNAUTHORIZED
|| this is ManualUnauthorisedException

fun Throwable.isForbidden() = this is HttpException && this.code() == HttpCodes.FORBIDDEN

object HttpCodes {
    const val UNAUTHORIZED = 401
    const val FORBIDDEN = 403
}
