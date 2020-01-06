package com.example.topdealtask.ui.register

import com.example.topdealtask.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [RegisterModule::class])
interface RegisterSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegisterSubcomponent
    }

    fun inject(LoginFragment: RegisterFragment)
}