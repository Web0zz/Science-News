package com.web0zz.science_news.domain.model.view.sections

import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.ContentType

data class ShortArticle(
    val article: Article
) : ArticleItem {
    override val itemId: Int = article.id
    override fun getType() = ContentType.SHORT_ARTICLE.ordinal
}
