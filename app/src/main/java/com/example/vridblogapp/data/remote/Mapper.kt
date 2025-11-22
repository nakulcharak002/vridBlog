package com.example.vridblogapp.data.remote

import com.example.vridblogapp.domain.model.BlogPost

fun BlogDto.toDomain(): BlogPost {
    return BlogPost(
        id = id,
        title = title.rendered.removeHtml(),
        excerpt = excerpt.rendered.removeHtml(),
        url = link
    )
}

fun String.removeHtml(): String {
    return replace(Regex("<.*?>"), "").trim()
}
