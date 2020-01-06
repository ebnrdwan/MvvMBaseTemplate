package com.example.topdealtask.data.dto.register

import com.example.topdealtask.data.dto.BaseModel
import com.google.gson.annotations.SerializedName

data class RegisterResponse(@SerializedName("UserId") val userId: String) : BaseModel()