package com.example.vridblogapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NeonArrow(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = Icons.Default.KeyboardArrowRight,
        contentDescription = null,
        tint = Color(0xFF5A8CFF),
        modifier = modifier.shadow(
            elevation = 16.dp,
            ambientColor = Color(0xFF5A8CFF),
            spotColor = Color(0xFF5A8CFF)
        )
    )
}
