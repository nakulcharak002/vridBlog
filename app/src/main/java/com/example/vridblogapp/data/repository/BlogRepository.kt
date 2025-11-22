package com.example.vridblogapp.domain.repository

import com.example.vridblogapp.domain.model.BlogPost

interface BlogRepository {
    suspend fun getBlogPosts(page: Int, pageSize: Int): List<BlogPost>
}

