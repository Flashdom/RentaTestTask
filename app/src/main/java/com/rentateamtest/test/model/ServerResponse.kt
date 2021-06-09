package com.rentateamtest.test.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val per_page: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val total_pages: Int,
    @Json(name = "data")
    val data: List<ServerUser>,
    @Json(name = "support")
    val support: Support
)