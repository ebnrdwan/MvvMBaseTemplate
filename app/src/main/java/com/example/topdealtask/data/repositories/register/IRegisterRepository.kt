package com.example.topdealtask.data.repositories.register


import com.example.topdealtask.data.dto.register.CitiesResponse
import com.example.topdealtask.data.dto.register.CountriesResponse
import com.example.topdealtask.data.dto.register.RegisterRequest
import com.example.topdealtask.data.dto.register.RegisterResponse
import io.reactivex.Observable
import io.reactivex.Single


interface IRegisterRepository {
    fun register(loginRequest: RegisterRequest): Observable<RegisterResponse>
    fun getCountries(): Observable<CountriesResponse>
    fun getCities(countryId: String): Observable<CitiesResponse>

}

