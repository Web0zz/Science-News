package com.web0zz.science_news.data.model

data class Article(
    val id: Int,
    val section: String,
    val date: String,
    val author: String,
    val title: String,
    val shortBody: String,
    val bodyText: List<String>,
    val contentImage: String,
    val thumbnail: String,
    var isSaved: Boolean = false,
    val shareLink: String
)

