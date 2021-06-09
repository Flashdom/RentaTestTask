package com.rentateamtest.test.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rentateamtest.test.model.User
import io.reactivex.rxjava3.core.Flowable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertUsers(users: List<User>)

    @Query("SELECT * FROM ${UserContract.TABLE_NAME}")
     fun getAllUsers(): Flowable<List<User>>

}