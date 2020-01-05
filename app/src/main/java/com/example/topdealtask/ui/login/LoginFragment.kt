package com.example.topdealtask.ui.login

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.topdealtask.R
import com.example.topdealtask.data.models.UiState
import com.example.topdealtask.ui.ApplicationController
import com.example.topdealtask.ui.base.BaseFragment
import com.example.topdealtask.util.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.loading_layout.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class LoginFragment : BaseFragment() {

    private lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<LoginViewModel> { viewModelFactory }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        compositeDisposable = CompositeDisposable()
        activity?.let {
            (it.application as ApplicationController)
                .appComponent.registerLoginComponent()
                .create()
                .inject(this)
        }
    }

    override fun getLayout(): Int = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListeners()
        attachObservers()
    }

    private fun setListeners() {
        observeOnMailTextField()
        observeOnPasswordTextField()
        onLoginClicked()
        setDoneActionOnPasswordField()
    }

    private fun attachObservers() {
        observeOnUiState()
        observeOnLoginData()
        mailTextChangesToObservable()
        passwordTextChangesToObservable()
    }

    private fun setDoneActionOnPasswordField() {
        ed_password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.login()
                true
            } else false
        }
    }

    private fun onLoginClicked() {
        btn_sign.setOnClickListener {
            viewModel.login()
        }
    }


    private fun observeOnLoginData() {
        viewModel.getSessionModel().observe(viewLifecycleOwner, Observer {
            if (it.status == 0) {
                activity?.showToast(
                    String.format(
                        resources.getString(R.string.welcome),
                        it.userInfo.displayName
                    )
                )
            } else it.message?.let { it1 -> activity?.showToast(it1) }
        })
    }

    private fun observeOnMailTextField() {
        viewModel.getMailFormStateModel().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is FormState.VALID -> {
                    setMailStatus(false)
                }
                else -> {
                    setMailStatus(true, state.message)
                }
            }
        })

    }

    private fun setMailStatus(
        error: Boolean,
        message: Int = R.string.error
    ) {
        if (error) {
            tv_mail_error.text = context?.resources?.getString(message)
            ed_mail.setBackgroundResource(R.drawable.bg_round_edit_text_error)
        } else {
            tv_mail_error.clear()
            ed_mail.setBackgroundResource(R.drawable.bg_round_edit_text)
        }
    }

    private fun setPasswordStatus(
        error: Boolean,
        message: Int = R.string.error
    ) {
        if (error) {
            tv_password_error.text = context?.resources?.getString(message)
            ed_password.setBackgroundResource(R.drawable.bg_round_edit_text_error)
        } else {
            tv_password_error.clear()
            ed_password.setBackgroundResource(R.drawable.bg_round_edit_text)
        }
    }

    private fun mailTextChangesToObservable() {
        compositeDisposable.add(
            ed_mail.onTextChangesObservable()
                .skip(Constants.RxEditTextConstants.SKIP)
                .debounce(Constants.RxEditTextConstants.DEBOUNCE, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    viewModel.isEmailValid(it)
                }.subscribe()
        )
    }

    private fun passwordTextChangesToObservable() {
        compositeDisposable.add(ed_password.onTextChangesObservable()
            .skip(Constants.RxEditTextConstants.SKIP)
            .debounce(Constants.RxEditTextConstants.DEBOUNCE, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                viewModel.isPasswordValid(it)
            }.subscribe {
                it.observe(viewLifecycleOwner, Observer { state ->
                    when (state) {
                        is FormState.VALID -> {
                            setPasswordStatus(false)
                        }
                        else -> {
                            setPasswordStatus(true, state.message)
                        }
                    }
                })

            })
    }

    private fun observeOnPasswordTextField() {
        viewModel.getPasswordFormStateModel().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is FormState.VALID -> {
                    setPasswordStatus(false)
                }
                else -> {
                    setPasswordStatus(true, state.message)
                }
            }
        })
    }

    override fun observeOnUiState() {
        viewModel.getUiStateModel().observe(viewLifecycleOwner, Observer {

            when (it) {
                is UiState.LOADING -> {
                    showLoading()
                }
                is UiState.SUCCESS -> {
                    showData()
                }
                is UiState.ERROR -> {
                    showError(it.message)
                }
                is UiState.NODATA -> {
                    showError(it.message)
                }
                is UiState.NOINTERNET -> {
                    showError(it.message)
                }

            }
        })
    }


    private fun showLoading() {
        setButtonsEnabled(false)
        btn_sign.isEnabled = false
        loading_view.show()
        view?.hideKeyboard(activity)

    }

    private fun setButtonsEnabled(enable: Boolean) {
        btn_sign.isEnabled = enable
        btn_facebook.isEnabled = enable
        btn_create_account.isEnabled = enable
    }


    private fun showData() {
        setButtonsEnabled(true)
        loading_view.hide()

    }

    private fun showError(message: Int) {
        setButtonsEnabled(true)
        loading_view.hide()
        activity?.showToast(getString(message))

    }


    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}
