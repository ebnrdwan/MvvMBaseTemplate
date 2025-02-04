package com.example.topdealtask.di

import com.example.topdealtask.networking.NetworkingClient
import com.example.topdealtask.ui.Configuration
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
object NetworkModule {

    /*baseUrl*/
    @Reusable
    @BaseUrl
    @Provides
    fun provideBaseUrl(): String {
        return Configuration.BaseUrl
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): LoggingInterceptor = NetworkingClient.provideLoggingInterceptor()

    @Singleton
    @Provides
    fun provideHttpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient =
        NetworkingClient.provideHttpClient(loggingInterceptor)


    @Singleton
    @Provides
    fun provideRetrofitInstance(
        @BaseUrl url: String,
        okHttpClient: OkHttpClient
    ): Retrofit = NetworkingClient.provideRetrofitInstance(url, okHttpClient)


}