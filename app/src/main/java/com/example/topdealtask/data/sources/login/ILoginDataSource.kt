package com.example.topdealtask.data.sources.login


import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.LoginResponse
import com.example.topdealtask.data.sources.IDataSources
import io.reactivex.Single

interface ILoginDataSource : IDataSources {
    fun getLogin(loginRequest: LoginRequest): Single<LoginResponse>
}