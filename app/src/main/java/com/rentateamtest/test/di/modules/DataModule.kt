package com.rentateamtest.test.di.modules

import android.app.Application
import androidx.room.Room
import com.rentateamtest.test.data.database.AppDatabase
import com.rentateamtest.test.data.database.UserDao
import com.rentateamtest.test.data.mappers.UsersMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

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

    @Provides
    fun provideUserMapper(): UsersMapper {
        return UsersMapper()
    }

}