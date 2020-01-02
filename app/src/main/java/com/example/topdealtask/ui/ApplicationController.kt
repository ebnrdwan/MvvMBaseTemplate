package com.example.topdealtask.ui

import android.app.Application

import com.example.topdealtask.di.AppComponent
import com.example.topdealtask.di.DaggerAppComponent

class ApplicationController : Application() {

    val appComponent: AppComponent by lazy {
        applicationInjector()
    }

    private fun applicationInjector(): AppComponent {
        return DaggerAppComponent.factory().createWith(this)
    }

}