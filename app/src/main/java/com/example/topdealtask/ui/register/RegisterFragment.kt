package com.example.topdealtask.ui.register

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.topdealtask.R
import com.example.topdealtask.ui.ApplicationController
import com.example.topdealtask.ui.base.BaseFragment
import javax.inject.Inject


class RegisterFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<RegisterViewModel> { viewModelFactory }

    override fun getLayout(): Int = R.layout.register_fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.let {
            (it.application as ApplicationController)
                .appComponent.registerSubComponent()
                .create()
                .inject(this)
        }
    }

    override fun observeOnUiState() {

    }

}
