package com.example.topdealtask.networking

import com.example.topdealtask.util.Constants
import com.example.topdealtask.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object NetworkingClient {

    fun provideHttpClient(
        loggingInterceptor: LoggingInterceptor,
        headers: Interceptor
    ): OkHttpClient {
        val timeout = Constants.Networking.RETROFIT_TIMEOUT_SECONDS
        return OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .callTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .addInterceptor(headers)
            .addInterceptor(loggingInterceptor) // interceptor
            .build() // http client
    }

    fun provideLoggingInterceptor(): LoggingInterceptor = LoggingInterceptor.Builder()
        .loggable(BuildConfig.DEBUG)
        .setLevel(Level.BASIC)
        .log(Platform.INFO)
        .request(Constants.Networking.API_REQUEST_TAG)
        .response(Constants.Networking.API_RESPONSE_TAG)
        .addHeader(Constants.Networking.APP_VERSION_TAG, BuildConfig.VERSION_NAME)
        .build()

    fun provideRetrofitInstance(
        url: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(Constants.Networking.Content_Type, Constants.Networking.Json)
                        .addHeader(
                            Constants.Networking.Accept_Language,
                            Locale.getDefault().language
                        )
                        .removeHeader("User-Agent")
                        .addHeader(
                            "User-Agent",
                            "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0"
                        )
                        .build()
                )
            }
        }

    }


}