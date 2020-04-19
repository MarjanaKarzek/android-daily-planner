package com.karzek.core.util

import com.karzek.core.networking.exception.ManualUnauthorisedException
import retrofit2.HttpException

fun Throwable.isUnauthorised() = this is HttpException && this.code() == HttpCodes.UNAUTHORIZED_CODE
    || this is ManualUnauthorisedException

object HttpCodes {
    const val UNAUTHORIZED_CODE = 401
}
