package com.pratik.coroutinesexample.Api

import com.pratik.coroutinesexample.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("getUser/{id}")
    suspend fun getUser(
        @Path("id") userId: Int
    ): User

}