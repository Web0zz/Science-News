package com.web0zz.science_news.domain.model.converter

import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.ContentType
import com.web0zz.science_news.domain.model.view.sections.*

fun Article.articleItemConverter(): ArticleItem {
    return when(this.contentType) {
        ContentType.OVERVIEW_ARTICLE -> OverviewArticle()
        ContentType.SHORT_ARTICLE -> ShortArticle(this)
        ContentType.TALL_ARTICLE -> TallArticle(this)
        else -> { ShortArticle(this) }
    }
}

fun List<Article>.articleListItemConverter(): ArticleItem {
    return TallLightArticle(this)
}