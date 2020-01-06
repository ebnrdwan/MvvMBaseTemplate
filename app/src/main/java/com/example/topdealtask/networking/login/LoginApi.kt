package com.example.topdealtask.networking.login

import com.example.topdealtask.data.dto.login.LoginRequest
import com.example.topdealtask.data.dto.login.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    /*============== end-points-start================*/
    @POST("Account/GetToken")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    /*============== end-points-end================*/
}
