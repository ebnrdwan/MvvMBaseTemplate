package com.example.topdealtask.di

import android.app.Application
import com.example.topdealtask.ui.login.Loginubcomponent
import com.example.topdealtask.ui.main.MainActivity
import com.example.topdealtask.ui.register.RegisterSubcomponent
import dagger.BindsInstance
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun createWith(@BindsInstance applicationController: Application): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun registerLoginComponent(): Loginubcomponent.Factory
    fun registerSubComponent(): RegisterSubcomponent.Factory

}


