package com.web0zz.science_news.data.model.view.sections

// TODO unused param will change when add overview adapter
data class OverviewArticle(
    val data: Nothing? = null
) : ArticleItem() {
    override fun getType() = Type.OVERVIEW_ARTICLE.ordinal
}