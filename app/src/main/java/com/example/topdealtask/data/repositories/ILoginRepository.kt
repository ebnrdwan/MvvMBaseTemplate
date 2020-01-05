package com.ebnrdwan.devlinktask.data.repository.LoginRepostory


import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import io.reactivex.Observable


interface ILoginRepository {
    fun login(loginRequest: LoginRequest): Observable<SessionModel>
}

