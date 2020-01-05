package com.example.topdealtask.di

import dagger.Module

@Module(
    includes = [
        ResourcesModule::class,
        NetworkModule::class,
        ViewModelFactoryBuilder::class]
)
object AppModule