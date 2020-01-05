package com.example.topdealtask.data.dto.login

import com.example.topdealtask.data.dto.BaseModel
import com.google.gson.annotations.SerializedName


data class SessionModel(
    @SerializedName("AccessToken")
    val accessToken: String = "", // 6_voq7WIRZr6plVSBxxlIuwEZ2Ym1ELKDO9I52bjgbUiQrbTwTdgZO2iDnLAlhwDkIyMkO1ogagVSL_wrKNRzo8D5w5TykCuRUPyIp3fBNi9v8xoHUZ5WZc25PxHfceRrvTtVIMUKnX9xvquJp4KuHxQS0AGRjP0bclYzJ98DbNH_SuidDVINJgQomxehp5c2RILhS2Q94IQIl3XqGz_j3ppQmq5t74YhG-qs5AXd5DkChYx0lNE2o8lhyhfKXidRJmI_E8U8ZIJdlseRft1GHOlk9Rle_wmOA1p2hOX2BxyLVPRcnB4uG9-hqp2JI7K53HzrCNISZ7xQRIjrd_CwVaLtEwMekFViXhGCaLxgf8onKp_thdVWNduy1-6G_9oi4-otaIZBRzoQFIv7ItbutJ72yVWXs-Fi2Sjj2SU88rcvzvUNPJikks-0NaI6OKSAPNGKCYz9mCx-SfFmayyORGSIUSxU02zVSk818JB60sfTGtGG5hCBOZSjmg7kKYIT42WkxKQ0bE7bzhWIJ0he-uusx-K7lSMsVi4gZo2zGM
    @SerializedName("UserInfo")
    val userInfo: UserInfo = UserInfo()
) : BaseModel() {
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
}