package com.rentateamtest.test.di.components

import android.app.Application
import com.rentateamtest.test.data.database.AppDatabase
import com.rentateamtest.test.data.database.UserDao
import com.rentateamtest.test.data.network.Api
import com.rentateamtest.test.di.modules.AppModule
import com.rentateamtest.test.di.modules.DataModule
import com.rentateamtest.test.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DataModule::class, AppModule::class])
interface AppComponent {

    fun getApi(): Api
    fun getDao(): UserDao
    fun getDatabase(): AppDatabase
    fun provideApplication(): Application
    fun getUserListComponent(): UserListComponent
}