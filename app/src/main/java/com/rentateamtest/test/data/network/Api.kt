package com.rentateamtest.test.data.network

import com.rentateamtest.test.model.ServerResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface Api {

    @GET("users/")
    fun getAllUsers(): Single<ServerResponse>


    companion object
    {
        private const val url = "https://reqres.in/api/"
        fun create() : Api
        {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create()
        }
    }

}