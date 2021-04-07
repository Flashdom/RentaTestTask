package com.rentateamtest.test.data

import com.rentateamtest.test.data.database.UserDao
import com.rentateamtest.test.data.network.Api
import com.rentateamtest.test.model.User
import javax.inject.Inject

class Repository @Inject constructor(private val userDao: UserDao, private val api: Api) {


    suspend fun getAllUsers(): List<User> {

        val usersList = api.getAllUsers().data.map {
            User(
                id = it.userId,
                email = it.email,
                fullName = "${it.first_name} ${it.last_name}",
                avatar = it.avatar
            )
        }
        userDao.insertUsers(usersList)
        return usersList
    }

    suspend fun getAllLocalUsers(): List<User> {
        return userDao.getAllUsers()
    }


}