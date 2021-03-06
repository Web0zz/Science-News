package com.web0zz.science_news.data.model.view.detail

data class ContentImage(
    val imageUrl: String
) : DetailItem {
    override fun getType() = DetailItem.Type.CONTENT_IMAGE.ordinal
}