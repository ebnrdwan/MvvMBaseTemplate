package com.ebnrdwan.devlinktask.data.repository.LoginRepositories

import android.content.Context
import com.ebnrdwan.devlinktask.data.repository.LoginRepostory.ILoginRepository
import com.ebnrdwan.devlinktask.data.sources.LoginDataSource.ILoginDataSource
import com.example.topdealtask.R
import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import com.example.topdealtask.di.MainLoginSource
import com.example.topdealtask.ui.base.BaseRepository
import com.example.topdealtask.util.NoInternetException
import io.reactivex.Observable
import javax.inject.Inject


class LoginRepository @Inject constructor(
    @MainLoginSource private val LoginDataSource: ILoginDataSource,
    private val mContext: Context
) : BaseRepository(mContext), ILoginRepository {
    override fun login(loginRequest: LoginRequest):
            Observable<SessionModel> {
        return checkInternetConnection()
            .switchMap { isConnected ->
                if (isConnected) LoginDataSource.getLogin(loginRequest).toObservable()
                else Observable.error(NoInternetException(mContext.resources.getString(R.string.no_internet)))
            }
    }
}

