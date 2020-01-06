package com.example.topdealtask.data.dto.register
import com.example.topdealtask.data.dto.BaseModel
import com.google.gson.annotations.SerializedName

data class CitiesResponse(
    @SerializedName("Cities")
    val cities: List<City> = listOf()
):BaseModel()