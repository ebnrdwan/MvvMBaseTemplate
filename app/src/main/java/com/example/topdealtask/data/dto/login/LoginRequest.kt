package com.example.topdealtask.data.dto.login


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("DeviceId")
    val deviceId: String = "",
    @SerializedName("Email")
    val email: String = "", // eng.abdoehab@gmail.com
    @SerializedName("Password")
    val password: String = "" // 123456
)