package com.karzek.authorization.domain.session.model

sealed class Session {
    data class Authorised(val weatherApiToken: String) : Session()
    object Unauthorised : Session()
}