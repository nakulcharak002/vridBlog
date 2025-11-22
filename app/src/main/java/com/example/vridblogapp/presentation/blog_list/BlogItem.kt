package com.example.vridblogapp.presentation.blog_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vridblogapp.domain.model.BlogPost
import com.example.vridblogapp.presentation.components.CategoryPill
import com.example.vridblogapp.presentation.components.GlassCard
import com.example.vridblogapp.presentation.components.NeonArrow

@Composable
fun BlogItem(
    post: BlogPost,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Color(0xFF5A8CFF))
            ) {
                onClick()
            }
    ) {

        // Category
        CategoryPill(text = "Latest")

        Spacer(modifier = Modifier.height(10.dp))

        // Title
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 18.sp,
                lineHeight = 22.sp
            ),
            color = Color.White.copy(alpha = 0.95f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Excerpt
        Text(
            text = post.excerpt,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.60f),
            lineHeight = 18.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Bottom row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tap to read full article",
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFFB7C7FF)
            )

            Spacer(modifier = Modifier.weight(1f))

            NeonArrow()
        }
    }
}
