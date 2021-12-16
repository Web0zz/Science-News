package com.web0zz.science_news.data.model.view.sections

import com.web0zz.science_news.data.model.Article

data class TallLightArticle(
    val articleList: List<Article>
) : ArticleItem {
    override fun getType() = ArticleItem.Type.TALL_LIGHT_ARTICLE.ordinal
}
