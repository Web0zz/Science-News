package com.web0zz.science_news.domain.model.view.detail

data class ContentImage(
    val imageUrl: String
) : DetailItem {
    override fun getType() = DetailItem.Type.CONTENT_IMAGE.ordinal
}