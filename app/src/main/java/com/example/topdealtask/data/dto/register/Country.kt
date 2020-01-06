package com.example.topdealtask.data.dto.register
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("CountryId")
    val countryId: String = "", // e4ccd1a0-3e5b-4c52-98fd-48075468dce0
    @SerializedName("CountryName")
    val countryName: String = "" // Zimbabwe
)