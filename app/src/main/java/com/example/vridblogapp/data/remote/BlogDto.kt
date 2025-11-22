package com.example.vridblogapp.data.remote

import com.squareup.moshi.Json

data class BlogDto(
    val id: Int,
    val link: String,
    val title: RenderedField,
    val excerpt: RenderedField,
    val content: RenderedField
)

data class RenderedField(
    @Json(name = "rendered")
    val rendered: String
)

