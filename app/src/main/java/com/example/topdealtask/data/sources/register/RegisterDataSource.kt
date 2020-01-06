package com.example.topdealtask.data.sources.register

import com.example.topdealtask.data.dto.register.CitiesResponse
import com.example.topdealtask.data.dto.register.CountriesResponse
import com.example.topdealtask.data.dto.register.RegisterRequest
import com.example.topdealtask.data.dto.register.RegisterResponse
import com.example.topdealtask.networking.register.RegisterApi
import io.reactivex.Single

class RegisterDataSource constructor(private val service: RegisterApi) :
    IRegisterDataSource {
    override fun getCountries(): Single<CountriesResponse> {
        return service.getCountries()
    }

    override fun getCities(countryId: String): Single<CitiesResponse> {
        return service.getCities(countryId)
    }

    override fun register(loginRequest: RegisterRequest): Single<RegisterResponse> {
        return service.register(loginRequest)
    }
}