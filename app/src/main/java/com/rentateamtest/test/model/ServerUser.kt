package com.rentateamtest.test.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerUser(
    @Json(name = "id")
    val userId: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
