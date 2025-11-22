package com.example.vridblogapp.data.repository

import com.example.vridblogapp.data.remote.ApiClient
import com.example.vridblogapp.data.remote.toDomain
import com.example.vridblogapp.domain.model.BlogPost
import com.example.vridblogapp.domain.repository.BlogRepository

class BlogRepositoryImpl : BlogRepository {

    private val api = ApiClient.api

    override suspend fun getBlogPosts(page: Int, pageSize: Int): List<BlogPost> {
        val remote = api.getPosts(perPage = pageSize, page = page)
        return remote.map { it.toDomain() }
    }
}
