package com.pratik.coroutinesexample.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {

    const val BASE_URL: String = "http://chawke.in:3001/"

    val retroBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: ApiService by lazy {
        retroBuilder.build()
            .create(ApiService::class.java)
    }
}