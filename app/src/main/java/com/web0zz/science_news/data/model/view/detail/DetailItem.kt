package com.web0zz.science_news.data.model.view.detail

sealed class DetailItem {
    abstract fun getType(): Int

    enum class Type {
        SHORT_DESCRIPTION,
        NORMAL_BODY,
        CONTENT_IMAGE
    }
}