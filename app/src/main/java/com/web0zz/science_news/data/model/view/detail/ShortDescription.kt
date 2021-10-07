package com.web0zz.science_news.data.model.view.detail

data class ShortDescription(
    val shortText: String
) : DetailItem() {
    override fun getType() = Type.SHORT_DESCRIPTION.ordinal
}