package com.example.topdealtask.data.sources.register

import com.example.topdealtask.data.dto.register.CitiesResponse
import com.example.topdealtask.data.dto.register.CountriesResponse
import com.example.topdealtask.data.dto.register.RegisterRequest
import com.example.topdealtask.data.dto.register.RegisterResponse
import com.example.topdealtask.data.sources.IDataSources
import io.reactivex.Single

interface IRegisterDataSource : IDataSources {
    fun register(loginRequest: RegisterRequest): Single<RegisterResponse>
    fun getCountries(): Single<CountriesResponse>
    fun getCities(countryId: String): Single<CitiesResponse>
}