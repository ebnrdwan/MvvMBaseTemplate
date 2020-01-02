package com.example.topdealtask.di

import com.example.topdealtask.di.NetworkModule
import dagger.Module

@Module(
    includes = [
        ResourcesModule::class,
        NetworkModule::class,
        ViewModelFactoryBuilder::class]
)
object AppModule