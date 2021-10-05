package com.web0zz.science_news.data.model.view

import com.web0zz.science_news.data.model.Article

data class TallLightArticle(
    val articleList: List<Article>
) : ArticleItem() {
    override fun getType() = Type.TALL_LIGHT_ARTICLE.ordinal
}
