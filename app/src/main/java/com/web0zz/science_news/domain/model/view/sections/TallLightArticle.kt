package com.web0zz.science_news.domain.model.view.sections

import com.web0zz.science_news.domain.model.Article

data class TallLightArticle(
    val articleList: List<Article>
) : ArticleItem {
    override fun getType() = ArticleItem.Type.TALL_LIGHT_ARTICLE.ordinal
}
