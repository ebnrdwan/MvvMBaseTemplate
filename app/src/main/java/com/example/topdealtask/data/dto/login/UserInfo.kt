package com.example.topdealtask.data.dto.login

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("DisplayName")
    val displayName: String = "", // test
    @SerializedName("Email")
    val email: String = "", // eng.abdoehab@gmail.com
    @SerializedName("HasUnReadMessages")
    val hasUnReadMessages: Boolean = false, // false
    @SerializedName("NumberOfUnReadMessages")
    val numberOfUnReadMessages: Int = 0, // 0
    @SerializedName("ProfileImage")
    val profileImage: Any = Any(), // null
    @SerializedName("UserId")
    val userId: String = "" // a5e644ac-4169-4a29-b313-f44203b4199a
)