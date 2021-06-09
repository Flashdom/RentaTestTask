package com.rentateamtest.test.data

import com.rentateamtest.test.data.database.UserDao
import com.rentateamtest.test.data.mappers.UsersMapper
import com.rentateamtest.test.data.network.Api
import com.rentateamtest.test.model.User
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Repository @Inject constructor(
    private val userDao: UserDao,
    private val api: Api,
    private val usersMapper: UsersMapper
) {

    fun getAllUsers(): Single<List<User>> {
        return api.getAllUsers().flatMap { serverResponse ->
            Single.just(usersMapper.mapServerResponseToUserList(serverResponse))
        }
    }


    fun listenLocalUsers(): Flowable<List<User>> {
        return userDao.getAllUsers()
    }
}
