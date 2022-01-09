package com.web0zz.science_news.domain.model.view.sections

import com.web0zz.science_news.domain.model.ContentType
import com.web0zz.science_news.domain.model.view.sections.ArticleItem.Companion.defaultOverviewItemId

data class OverviewArticle(
    val data: Nothing? = null
) : ArticleItem {
    override val itemId: Int = defaultOverviewItemId
    override fun getType() = ContentType.OVERVIEW_ARTICLE.ordinal
}