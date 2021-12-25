package com.web0zz.science_news.domain.model

import android.net.Uri

data class ShortVideo(
    val id: Int,
    val videoArticle: Article,
    val videoUrl: Uri
)

