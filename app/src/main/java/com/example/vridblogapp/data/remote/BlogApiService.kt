package com.example.vridblogapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApiService {

    @GET("wp-json/wp/v2/posts")
    suspend fun getPosts(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): List<BlogDto>
}
