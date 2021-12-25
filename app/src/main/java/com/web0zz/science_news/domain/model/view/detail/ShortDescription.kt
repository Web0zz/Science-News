package com.web0zz.science_news.domain.model.view.detail

data class ShortDescription(
    val shortText: String
) : DetailItem {
    override fun getType() = DetailItem.Type.SHORT_DESCRIPTION.ordinal
}