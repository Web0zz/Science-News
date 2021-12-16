package com.web0zz.science_news.data.model.view.sections

data class OverviewArticle(
    val data: Nothing? = null
) : ArticleItem {
    override fun getType() = ArticleItem.Type.OVERVIEW_ARTICLE.ordinal
}