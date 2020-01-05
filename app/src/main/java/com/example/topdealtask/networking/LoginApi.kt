package com.example.topdealtask.networking

import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.SessionModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApi {

    /*============== end-points-start================*/
    @POST("Account/GetToken")
    fun login(@Body loginRequest: LoginRequest): Single<SessionModel>

    /*============== end-points-end================*/
}
