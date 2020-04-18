package com.karzek.core.ui.error

sealed class UIError {
    object NetworkConnection : UIError()
    object Unknown : UIError()
}