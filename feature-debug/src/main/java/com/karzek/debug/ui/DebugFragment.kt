package com.karzek.debug.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.karzek.core.ui.base.BaseFragment
import com.karzek.core.ui.error.UIError.NetworkConnection
import com.karzek.core.ui.error.UIError.Unauthorised
import com.karzek.core.ui.error.UIError.Unknown
import com.karzek.debug.R
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_debug.action_save
import kotlinx.android.synthetic.main.fragment_debug.input_weather_api_key
import kotlinx.android.synthetic.main.fragment_debug.loading

class DebugFragment : BaseFragment(R.layout.fragment_debug) {

    private val viewModel: DebugViewModel by bindViewModel()

    override fun getTagForStack() = DebugFragment::class.java.toString()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToViewModel()
        subscribeToUI()
    }

    private fun subscribeToViewModel() {
        viewModel.error
            .subscribeBy {
                when (it) {
                    NetworkConnection -> Toast.makeText(context, "NetworkError", Toast.LENGTH_LONG).show()
                    Unauthorised -> Toast.makeText(context, "UnauthorisedError", Toast.LENGTH_LONG).show()
                    Unknown -> Toast.makeText(context, "UnknownError", Toast.LENGTH_LONG).show()
                }
            }
            .addTo(compositeDisposable)

        viewModel.loading
            .subscribeBy {
                if (it) {
                    loading.visibility = View.VISIBLE
                } else {
                    loading.visibility = View.GONE
                }
            }
            .addTo(compositeDisposable)
    }

    private fun subscribeToUI() {
        action_save.setOnClickListener {
            val input = input_weather_api_key.text.toString()
            if (input.isNotEmpty()) {
                viewModel.onSaveClicked(input)
            }
        }
    }

    override fun onDestroyView() {
        action_save.setOnClickListener(null)
        super.onDestroyView()
    }

}