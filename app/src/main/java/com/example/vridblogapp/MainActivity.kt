package com.example.vridblogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.vridblogapp.presentation.navigation.AppNavHost
import com.example.vridblogapp.presentation.theme.VridBlogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VridBlogTheme {
                AppNavHost()
            }
        }
    }
}
