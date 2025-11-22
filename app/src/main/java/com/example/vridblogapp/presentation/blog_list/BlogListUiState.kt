package com.example.vridblogapp.presentation.blog_list

import com.example.vridblogapp.domain.model.BlogPost

data class BlogListUiState(
    val isLoading: Boolean = false,
    val posts: List<BlogPost> = emptyList(),
    val error: String? = null,
    val page: Int = 1,
    val endReached: Boolean = false
)
