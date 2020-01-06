package com.example.topdealtask.ui.register

import androidx.lifecycle.ViewModel
import com.example.topdealtask.data.repositories.register.IRegisterRepository
import com.example.topdealtask.data.repositories.register.RegisterRepository
import com.example.topdealtask.data.sources.register.IRegisterDataSource
import com.example.topdealtask.data.sources.register.RegisterDataSource
import com.example.topdealtask.di.FragmentScope
import com.example.topdealtask.di.MainLoginSource
import com.example.topdealtask.di.ViewModelKey
import com.example.topdealtask.networking.register.RegisterApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(includes = [BindViewModel::class])
object RegisterModule {

    @FragmentScope
    @JvmStatic
    @Provides
    fun bindApiLoginServices(retrofit: Retrofit): RegisterApi =
        retrofit.create(RegisterApi::class.java)


    @FragmentScope
    @JvmStatic
    @MainLoginSource
    @Provides
    fun bindLoginDataSource(apiService: RegisterApi): IRegisterDataSource =
        RegisterDataSource(apiService)

}

@Module
abstract class BindViewModel {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindViewModel(viewModel: RegisterViewModel): ViewModel

    @FragmentScope
    @Binds
    abstract fun bindRepo(repo: RegisterRepository): IRegisterRepository

}