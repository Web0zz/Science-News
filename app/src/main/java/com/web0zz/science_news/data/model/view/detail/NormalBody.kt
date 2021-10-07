package com.web0zz.science_news.data.model.view.detail

data class NormalBody(
    val normalText: String
) : DetailItem() {
    override fun getType() = Type.NORMAL_BODY.ordinal
}