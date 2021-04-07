package com.rentateamtest.test.di

import android.app.Application
import androidx.room.Room
import com.rentateamtest.test.data.database.AppDatabase
import com.rentateamtest.test.data.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        val databaseName = "MyDatabase"
        return Room.databaseBuilder(application, AppDatabase::class.java, databaseName).build()
    }

    @Provides
    fun provideDao(db: AppDatabase): UserDao {
        return db.userDao()
    }
}