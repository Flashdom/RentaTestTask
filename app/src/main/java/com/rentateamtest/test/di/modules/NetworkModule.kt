package com.rentateamtest.test.di.modules

import com.rentateamtest.test.data.network.Api
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideApi(): Api {
        return Api.create()
    }
}