package com.example.topdealtask.data.models

import com.example.topdealtask.R
import com.example.topdealtask.data.dto.BaseModel
import com.example.topdealtask.data.dto.login.SessionModel


sealed class UiState {
    abstract var message: Int

    object LOADING : UiState() {
        override var message: Int = R.string.loading
    }

    object RELOADING : UiState() {
        override var message: Int = R.string.reoading
    }

    object SUCCESS : UiState() {
        override var message: Int = R.string.success

    }

    sealed class Loaded<out T : BaseModel>(val result: T) : UiState() {
        sealed class loginResult(data: SessionModel) : Loaded<SessionModel>(data)
    }


    object ERROR : UiState() {
        override var message: Int = R.string.no_internet

    }

    object NODATA : UiState() {
        override var message: Int = R.string.no_data

    }

    object NOINTERNET : UiState() {
        override var message: Int = R.string.no_internet

    }
}
