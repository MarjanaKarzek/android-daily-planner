package com.karzek.authorization.domain.session

import com.karzek.authorization.domain.session.model.Session

interface ISessionManager {

    fun getSession(): Session

    fun unauthoriseSession()

}