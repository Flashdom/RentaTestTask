package com.rentateamtest.test.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Support(val url: String, val text: String)