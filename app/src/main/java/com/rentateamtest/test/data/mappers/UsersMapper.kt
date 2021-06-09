package com.rentateamtest.test.data.mappers

import com.rentateamtest.test.model.ServerResponse
import com.rentateamtest.test.model.User

class UsersMapper {

    fun mapServerResponseToUserList(response: ServerResponse): List<User> {
        return response.data.map { serverUser ->
            User(
                id = serverUser.userId,
                email = serverUser.email,
                fullName = "${serverUser.first_name} ${serverUser.last_name}",
                avatar = serverUser.avatar
            )

        }
    }
}