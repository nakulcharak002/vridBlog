package com.example.vridblogapp.presentation.blog_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vridblogapp.data.repository.BlogRepositoryImpl
import com.example.vridblogapp.domain.usecase.GetBlogPostsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BlogListViewModel : ViewModel() {

    private val getBlogPostsUseCase = GetBlogPostsUseCase(BlogRepositoryImpl())

    private val _uiState = MutableStateFlow(BlogListUiState())
    val uiState: StateFlow<BlogListUiState> = _uiState

    private val pageSize = 10
    private var isLoading = false

    init {
        loadNextPage()
    }

    fun loadNextPage() {
        if (isLoading) return

        val state = _uiState.value
        isLoading = true

        viewModelScope.launch {
            try {
                _uiState.value = state.copy(isLoading = true)

                val result = getBlogPostsUseCase(state.page, pageSize)

                _uiState.value = _uiState.value.copy(
                    posts = state.posts + result,
                    page = state.page + 1,
                    isLoading = false,
                    endReached = result.size < pageSize
                )

            } catch (e: Exception) {
                _uiState.value = state.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
            isLoading = false
        }
    }
}
