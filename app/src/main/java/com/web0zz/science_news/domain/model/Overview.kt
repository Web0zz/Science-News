package com.web0zz.science_news.domain.model

data class Overview(
    val id: Int,
    val thumbnail_image: String,
    val name: String,
    var videos: List<ShortVideo> = emptyList()
)