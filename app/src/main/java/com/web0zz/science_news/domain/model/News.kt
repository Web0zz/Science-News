package com.web0zz.science_news.domain.model

import com.web0zz.science_news.domain.model.view.sections.ArticleItem

data class News(
    val newsId: Int,
    val articles: List<ArticleItem>
)