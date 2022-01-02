package com.web0zz.science_news.domain.model

data class News(
    val newsId: Int,
    val article: List<Article>,
    val overview: List<Overview>
)