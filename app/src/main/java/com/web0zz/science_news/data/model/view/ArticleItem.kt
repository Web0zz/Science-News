package com.web0zz.science_news.data.model.view

sealed class ArticleItem {
    abstract fun getType(): Int

    enum class Type {
        SHORT_ARTICLE,
        TALL_ARTICLE,
        TALL_LIGHT_ARTICLE
    }
}