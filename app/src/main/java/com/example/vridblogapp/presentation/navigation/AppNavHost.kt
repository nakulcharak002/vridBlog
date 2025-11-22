package com.example.vridblogapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.vridblogapp.presentation.blog_detail.BlogDetailScreen
import com.example.vridblogapp.presentation.blog_list.BlogListScreen
import java.net.URLDecoder
import java.net.URLEncoder

object Routes {
    const val LIST = "blog_list"
    const val DETAIL = "blog_detail"
}

@Composable
fun AppNavHost() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "list") {

        composable("list") {
            BlogListScreen(
                onPostClick = { post ->
                    val encoded = URLEncoder.encode(post.url, "UTF-8")
                    nav.navigate("detail/$encoded")
                }
            )
        }

        composable(
            "detail/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backstack ->
            val encoded = backstack.arguments?.getString("url")!!
            val url = URLDecoder.decode(encoded, "UTF-8")

            BlogDetailScreen(url = url, onBack = { nav.popBackStack() })
        }
    }
}

