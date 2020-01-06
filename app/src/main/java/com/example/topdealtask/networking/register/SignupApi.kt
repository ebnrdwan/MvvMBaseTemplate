package com.example.topdealtask.networking.register
import com.example.topdealtask.data.dto.register.CitiesResponse
import com.example.topdealtask.data.dto.register.CountriesResponse
import com.example.topdealtask.data.dto.register.RegisterRequest
import com.example.topdealtask.data.dto.register.RegisterResponse
import io.reactivex.Single
import retrofit2.http.*

interface RegisterApi {

    /*============== end-points-start================*/
    @POST("Account/Register")
    fun register(@Body registerRequest: RegisterRequest): Single<RegisterResponse>

    @POST("Countries/GetAllCities")
    @FormUrlEncoded
    fun getCities(@Field("CountryId") countryId: String): Single<CitiesResponse>

    @GET("Countries/GetAllCountries")
    fun getCountries(): Single<CountriesResponse>
    /*============== end-points-end================*/
}
