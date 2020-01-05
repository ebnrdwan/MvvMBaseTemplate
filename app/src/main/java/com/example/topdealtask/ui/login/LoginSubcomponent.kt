package com.ebnrdwan.devlinktask.ui.Login
import com.example.topdealtask.di.FragmentScope
import com.example.topdealtask.ui.login.LoginFragment
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