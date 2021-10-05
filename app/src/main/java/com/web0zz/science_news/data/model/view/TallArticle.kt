package com.web0zz.science_news.data.model.view

import com.web0zz.science_news.data.model.Article

data class TallArticle(
    val article: Article
) : ArticleItem() {
    override fun getType() = Type.TALL_ARTICLE.ordinal
}
