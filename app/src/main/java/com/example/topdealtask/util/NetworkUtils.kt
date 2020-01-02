package com.example.topdealtask.util

import android.content.Context
import android.net.ConnectivityManager
import com.example.topdealtask.R
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketException

object NetworkUtils {
    fun isInternetOn(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}


fun Throwable.handleErrors(): Int {
    return when (val error = this) {
        is HttpException -> when (error.code()) {
            404 -> R.string.not_found
            400 -> R.string.bad_request
            401 -> R.string.unauthotized
            500 -> R.string.server_error
            else -> R.string.error
        }
        is SocketException,
       is IOException-> R.string.no_internet
        else -> R.string.error
    }
}