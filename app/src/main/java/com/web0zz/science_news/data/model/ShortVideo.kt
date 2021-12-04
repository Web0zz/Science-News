package com.web0zz.science_news.data.model

import android.net.Uri

data class ShortVideo(
    val id: Int,
    val videoArticle: Article,
    val videoUrl: Uri
)

