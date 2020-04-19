package com.karzek.daily.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.karzek.core.ui.base.BaseFragment
import com.karzek.core.ui.error.UIError.NetworkConnection
import com.karzek.core.ui.error.UIError.Unauthorised
import com.karzek.core.ui.error.UIError.Unknown
import com.karzek.daily.R.layout
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_daily.quote_author
import kotlinx.android.synthetic.main.fragment_daily.quote_text
import kotlinx.android.synthetic.main.fragment_daily.weather_temperature

class DailyFragment : BaseFragment(layout.fragment_daily) {

    private val viewModel: DailyViewModel by bindViewModel()

    override fun getTagForStack() = DailyFragment::class.java.toString()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModel()

        viewModel.getQuoteOfTheDay()
        viewModel.getCurrentWeather()
    }

    private fun subscribeToViewModel() {
        viewModel.error
            .subscribeBy {
                when(it) {
                    NetworkConnection -> Toast.makeText(context, "NetworkError", Toast.LENGTH_LONG).show()
                    Unauthorised -> Toast.makeText(context, "UnauthorisedError", Toast.LENGTH_LONG).show()
                    Unknown -> Toast.makeText(context, "UnknownError", Toast.LENGTH_LONG).show()
                }
            }
            .addTo(compositeDisposable)

        viewModel.quote
            .subscribeBy {
                quote_text.text = it.text
                quote_author.text = it.author
            }
            .addTo(compositeDisposable)

        viewModel.currentWeather
            .subscribeBy {
                weather_temperature.text = "${it.temperature} Grad"
            }
            .addTo(compositeDisposable)
    }

    companion object {
        fun newInstance() = DailyFragment()
    }
}