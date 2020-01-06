package com.example.topdealtask.data.sources.login

import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.LoginResponse
import com.example.topdealtask.networking.login.LoginApi
import io.reactivex.Single

class LoginDataSource constructor(private val service: LoginApi) :
    ILoginDataSource {
    override fun getLogin(loginRequest: LoginRequest): Single<LoginResponse> {
        return service.login(loginRequest)
    }
}