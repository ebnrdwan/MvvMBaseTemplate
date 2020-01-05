package com.example.topdealtask.data.dto

import com.google.gson.annotations.SerializedName

abstract class BaseModel(
    @SerializedName("Status") val status: Int? = null,
    @SerializedName("Message") val message: String? = null
)