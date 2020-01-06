package com.example.topdealtask.data.repositories.login


import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.LoginResponse
import io.reactivex.Observable


interface ILoginRepository {
    fun login(loginRequest: LoginRequest): Observable<LoginResponse>
}

