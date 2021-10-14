package com.web0zz.science_news.data.model.view.sections

sealed class ArticleItem {
    abstract fun getType(): Int

    enum class Type {
        OVERVIEW_ARTICLE,
        SHORT_ARTICLE,
        TALL_ARTICLE,
        TALL_LIGHT_ARTICLE
    }
}