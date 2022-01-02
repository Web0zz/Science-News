package com.web0zz.science_news.domain.model.view.sections

import com.web0zz.science_news.domain.model.ContentType

data class OverviewArticle(
    val data: Nothing? = null
) : ArticleItem {
    override fun getType() = ContentType.OVERVIEW_ARTICLE.ordinal
}