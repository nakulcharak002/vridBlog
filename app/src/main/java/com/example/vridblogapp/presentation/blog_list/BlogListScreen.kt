package com.example.vridblogapp.presentation.blog_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vridblogapp.domain.model.BlogPost
import com.example.vridblogapp.presentation.components.GradientAppBar
import com.example.vridblogapp.presentation.theme.DarkBackground

@Composable
fun BlogListScreen(
    onPostClick: (BlogPost) -> Unit
) {
    val viewModel: BlogListViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        GradientAppBar(title = "VRID Blog")

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            itemsIndexed(state.posts) { index, post ->
                BlogItem(
                    post = post,
                    onClick = { onPostClick(post) }
                )

                // Trigger pagination when near the end
                if (index >= state.posts.size - 3 &&
                    !state.endReached &&
                    !state.isLoading
                ) {
                    LaunchedEffect(Unit) {
                        viewModel.loadNextPage()
                    }
                }
            }

            // Loading indicator at the bottom
            item {
                if (state.isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = Color(0xFF5A8CFF)
                        )
                    }
                }
            }
        }
    }
}