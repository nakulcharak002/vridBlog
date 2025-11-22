package com.example.vridblogapp.domain.usecase

import com.example.vridblogapp.domain.repository.BlogRepository

class GetBlogPostsUseCase(private val repository: BlogRepository) {
    suspend operator fun invoke(page: Int, pageSize: Int) =
        repository.getBlogPosts(page, pageSize)
}
