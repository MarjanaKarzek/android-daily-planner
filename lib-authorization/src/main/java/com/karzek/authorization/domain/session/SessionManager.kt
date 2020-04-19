package com.karzek.authorization.domain.session

import com.karzek.authorization.domain.session.model.Session
import com.karzek.authorization.domain.session.model.Session.Authorised
import com.karzek.authorization.domain.session.model.Session.Unauthorised
import com.karzek.authorization.domain.token.ITokenRepository
import com.karzek.authorization.domain.token.model.Token.WEATHER_API_TOKEN
import javax.inject.Inject

class SessionManager @Inject constructor(
    private val tokenRepository: ITokenRepository
) : ISessionManager {

    private var session: Session = Unauthorised

    override fun getSession(): Session {
        if (session == Unauthorised) {
            val weatherApiToken = tokenRepository.getToken(WEATHER_API_TOKEN)
            if (weatherApiToken != null) {
                session = Authorised(weatherApiToken)
            }
        }
        return session
    }

    override fun unauthoriseSession() {
        session = Unauthorised
    }

}