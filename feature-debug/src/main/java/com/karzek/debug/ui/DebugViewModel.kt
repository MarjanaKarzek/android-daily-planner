package com.karzek.debug.ui

import com.karzek.authorization.domain.IUpdateToken
import com.karzek.authorization.domain.IUpdateToken.Input
import com.karzek.authorization.domain.IUpdateToken.Output.Success
import com.karzek.authorization.domain.token.model.Token.WEATHER_API_TOKEN
import com.karzek.core.ui.base.BaseViewModel
import com.karzek.core.ui.error.UIError.Unknown
import com.karzek.core.util.doOnIoObserveOnMain
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class DebugViewModel @Inject constructor(
    private val updateToken: IUpdateToken
) : BaseViewModel() {

    val loading = BehaviorSubject.create<Boolean>()

    fun onSaveClicked(token: String) {
        updateToken.execute(Input(WEATHER_API_TOKEN, token))
            .doOnIoObserveOnMain()
            .doOnSubscribe { loading.onNext(true) }
            .subscribeBy {
                loading.onNext(false)
                if (it !is Success) {
                    error.onNext(Unknown)
                }
            }
            .addTo(compositeDisposable)
    }

}