package com.web0zz.science_news.domain.model.view.sections

interface ArticleItem {
    fun getType(): Int

    enum class Type {
        OVERVIEW_ARTICLE,
        SHORT_ARTICLE,
        TALL_ARTICLE,
        TALL_LIGHT_ARTICLE
    }
}