package com.web0zz.science_news.data.model

data class ShortVideo(
    val id: Int,
    val videoArticle: Article,
    val videoUrl: String = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
)

