package com.example.topdealtask.ui.login

import com.example.topdealtask.R

sealed class FormState {
    abstract var message: Int

    class VALID(override var message: Int =R.string.success) : FormState()
    class INVALID(override var message: Int = R.string.empty_field) : FormState()


}