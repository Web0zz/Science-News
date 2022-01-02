package com.web0zz.science_news.domain.model.view.sections

import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.ContentType

data class TallLightArticle(
    val articleList: List<Article>
) : ArticleItem {
    override fun getType() = ContentType.TALL_LIGHT_ARTICLE.ordinal
}
