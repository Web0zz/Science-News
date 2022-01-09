package com.web0zz.science_news.domain.model.view.sections

interface ArticleItem {
    val itemId: Int
    fun getType(): Int

    companion object {
        const val defaultOverviewItemId = -1
    }
}