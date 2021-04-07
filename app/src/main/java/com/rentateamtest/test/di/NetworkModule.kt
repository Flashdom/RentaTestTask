package com.rentateamtest.test.di

import com.rentateamtest.test.data.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(): Api {
        return Api.create()
    }
}