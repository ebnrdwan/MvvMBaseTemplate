package com.example.topdealtask.data.dto.register
import com.example.topdealtask.data.dto.BaseModel
import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("Countries")
    val countries: List<Country> = listOf()
):BaseModel()