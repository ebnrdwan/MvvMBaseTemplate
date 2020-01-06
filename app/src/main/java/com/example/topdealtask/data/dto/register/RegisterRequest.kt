package com.example.topdealtask.data.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("Biography")
    val biography: Any = Any(), // null
    @SerializedName("CityId")
    val cityId: String = "", // 54b6d767-a647-4830-97e3-631876ed6f8d
    @SerializedName("DisplayName")
    val displayName: String = "", // test
    @SerializedName("Email")
    val email: String = "", // eng.abdoehab@gmail.com
    @SerializedName("FacebookId")
    val facebookId: Any = Any(), // null
    @SerializedName("FacebookToken")
    val facebookToken: Any = Any(), // null
    @SerializedName("Gender")
    val gender: Any = Any(), // null
    @SerializedName("Password")
    val password: String = "" // 123456
)