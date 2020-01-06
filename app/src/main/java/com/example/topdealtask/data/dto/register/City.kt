package com.example.topdealtask.data.dto.register

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("CityId")
    val cityId: String = "", // 5d180315-ef8d-4002-8047-8f02ac29f1f6
    @SerializedName("CityName")
    val cityName: String = "" // Zabul
)