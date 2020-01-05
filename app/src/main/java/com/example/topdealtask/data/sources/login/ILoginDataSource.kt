package com.ebnrdwan.devlinktask.data.sources.LoginDataSource


import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import com.example.topdealtask.data.sources.IDataSources
import io.reactivex.Single

interface ILoginDataSource : IDataSources {
    fun getLogin(loginRequest: LoginRequest): Single<SessionModel>
}