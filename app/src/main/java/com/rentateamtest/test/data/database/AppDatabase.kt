package com.rentateamtest.test.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rentateamtest.test.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}