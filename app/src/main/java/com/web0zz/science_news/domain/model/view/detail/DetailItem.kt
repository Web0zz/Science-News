package com.web0zz.science_news.domain.model.view.detail

interface DetailItem {
    fun getType(): Int

    enum class Type {
        SHORT_DESCRIPTION,
        NORMAL_BODY,
        CONTENT_IMAGE
    }
}