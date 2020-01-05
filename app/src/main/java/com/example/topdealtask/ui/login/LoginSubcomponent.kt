package com.example.topdealtask.ui.login
import com.example.topdealtask.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [LoginModule::class])
interface Loginubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): Loginubcomponent
    }

    fun inject(LoginFragment: LoginFragment)
}