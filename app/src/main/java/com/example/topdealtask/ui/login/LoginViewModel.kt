package com.example.topdealtask.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.topdealtask.data.repositories.ILoginRepository
import com.example.topdealtask.R
import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import com.example.topdealtask.data.models.FormState
import com.example.topdealtask.data.models.UiState
import com.example.topdealtask.ui.base.BaseViewModel
import com.example.topdealtask.util.Constants
import com.example.topdealtask.util.Logger
import com.example.topdealtask.util.NoInternetException
import com.example.topdealtask.util.handleErrors
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject


class LoginViewModel @Inject constructor(private val LoginRepository: ILoginRepository) :
    BaseViewModel() {
    private val _uiStatModel = MutableLiveData<UiState>()
    private val _mailFormState = MutableLiveData<FormState>()
    private val _passwordFormState = MutableLiveData<FormState>()
    private val _mailInput = MutableLiveData<String>()
    private val _passwordInput = MutableLiveData<String>()
    private val _sessionModel = MutableLiveData<SessionModel>()


    fun getUiStateModel(): LiveData<UiState> {
        return _uiStatModel
    }

    fun getSessionModel(): LiveData<SessionModel> {
        return _sessionModel
    }


    fun getMailFormStateModel(): LiveData<FormState> {
        return _mailFormState
    }

    fun getPasswordFormStateModel(): LiveData<FormState> {
        return _passwordFormState
    }

    fun isEmailValid(input: String): LiveData<FormState> {
        _mailInput.value = input
        if (input.isEmpty()) return _mailFormState.apply {
            value = FormState.INVALID(R.string.email_error)

        }

        return _mailFormState.apply {
            value = FormState.VALID()
        }
    }

    fun isPasswordValid(input: String): LiveData<FormState> {
        _passwordInput.value = input
        if (input.isEmpty()) return _passwordFormState.apply {
            value = FormState.INVALID(R.string.password_error)
        }
        return _passwordFormState.apply {
            value = FormState.VALID()
        }
    }


    fun login() {
        if (_mailInput.value.isNullOrEmpty()) {
            _mailFormState.value = FormState.INVALID(message = R.string.email_error)
            return
        }
        if (_passwordInput.value.isNullOrEmpty()) {
            _passwordFormState.value = FormState.INVALID(message = R.string.password_error)
            return
        }

        performLogin(
            LoginRequest(
                email = _mailInput.value!!,
                password = requireNotNull(_passwordInput.value)
            ),
            UiState.LOADING
        )
    }


    /*================fetch Login remotely================*/
    private fun performLogin(loginRequest: LoginRequest, uiState: UiState) {
        addDisposable(
            LoginRepository.login(loginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _uiStatModel.value = uiState
                }
                .subscribeLogin()
        )
    }


    private fun Observable<SessionModel>.subscribeLogin(): Disposable {
        return this.subscribe({
            _sessionModel.value = it
            _uiStatModel.value = UiState.SUCCESS
        }, {
            Logger.log(message = "${Constants.Logging.RX_TAG_ERROR}: $it")
            if (it is NoInternetException)
                _uiStatModel.value = UiState.NOINTERNET
            else _uiStatModel.value = UiState.ERROR.apply { message = it.handleErrors() }
        }, {

        })
    }

}