package com.example.topdealtask.data.repositories.register
import android.content.Context
import com.example.topdealtask.R
import com.example.topdealtask.data.dto.register.CitiesResponse
import com.example.topdealtask.data.dto.register.CountriesResponse
import com.example.topdealtask.data.dto.register.RegisterRequest
import com.example.topdealtask.data.dto.register.RegisterResponse
import com.example.topdealtask.data.sources.register.IRegisterDataSource
import com.example.topdealtask.di.MainLoginSource
import com.example.topdealtask.ui.base.BaseRepository
import com.example.topdealtask.util.NoInternetException
import io.reactivex.Observable
import javax.inject.Inject


class RegisterRepository @Inject constructor(
    @MainLoginSource private val dataSource: IRegisterDataSource,
    private val mContext: Context
) : BaseRepository(mContext), IRegisterRepository {
    override fun getCountries(): Observable<CountriesResponse> {
        return checkInternetConnection()
            .switchMap { isConnected ->
                if (isConnected) dataSource.getCountries().toObservable()
                else Observable.error(NoInternetException(mContext.resources.getString(R.string.no_internet)))
            }
    }

    override fun getCities(countryId: String): Observable<CitiesResponse> {
        return checkInternetConnection()
            .switchMap { isConnected ->
                if (isConnected) dataSource.getCities(countryId).toObservable()
                else Observable.error(NoInternetException(mContext.resources.getString(R.string.no_internet)))
            }
    }

    override fun register(loginRequest: RegisterRequest):
            Observable<RegisterResponse> {
        return checkInternetConnection()
            .switchMap { isConnected ->
                if (isConnected) dataSource.register(loginRequest).toObservable()
                else Observable.error(NoInternetException(mContext.resources.getString(R.string.no_internet)))
            }
    }
}

