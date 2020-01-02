package com.example.topdealtask.ui.base

import android.content.Context
import com.example.topdealtask.util.NetworkUtils.isInternetOn
import io.reactivex.Observable

abstract class BaseRepository(val context: Context) {
     fun checkInternetConnection(): Observable<Boolean> {
        return Observable.just(isInternetOn(context))
    }
}