package com.example.topdealtask.data.sources.login


import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import com.example.topdealtask.networking.LoginApi
import io.reactivex.Single

class LoginDataSource constructor(private val service: LoginApi) :
    ILoginDataSource {
    override fun getLogin(loginRequest: LoginRequest): Single<SessionModel> {
        return service.login(loginRequest)
    }
}