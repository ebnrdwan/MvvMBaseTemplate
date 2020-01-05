package com.ebnrdwan.devlinktask.ui.Login

import androidx.lifecycle.ViewModel
import com.ebnrdwan.devlinktask.data.repository.LoginRepositories.LoginRepository
import com.ebnrdwan.devlinktask.data.repository.LoginRepostory.ILoginRepository
import com.ebnrdwan.devlinktask.data.sources.LoginDataSource.LoginDataSource
import com.ebnrdwan.devlinktask.data.sources.LoginDataSource.ILoginDataSource
import com.example.topdealtask.di.FragmentScope
import com.example.topdealtask.di.MainLoginSource
import com.example.topdealtask.di.ViewModelKey
import com.example.topdealtask.networking.LoginApi
import com.example.topdealtask.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(includes = [BindViewModel::class])
object LoginModule {

    @FragmentScope
    @JvmStatic
    @Provides
    fun bindApiLoginServices(retrofit: Retrofit): LoginApi =
        retrofit.create(LoginApi::class.java)


    @FragmentScope
    @JvmStatic
    @MainLoginSource
    @Provides
    fun bindLoginDataSource(apiService: LoginApi): ILoginDataSource =
        LoginDataSource(apiService)

}

@Module
abstract class BindViewModel {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindViewModel(viewModel: LoginViewModel): ViewModel

    @FragmentScope
    @Binds
    abstract fun bindRepo(repo: LoginRepository): ILoginRepository

}