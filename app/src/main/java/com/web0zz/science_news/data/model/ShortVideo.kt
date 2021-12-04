package com.web0zz.science_news.data.model

import android.net.Uri
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.web0zz.science_news.R

data class ShortVideo(
    val id: Int,
    val videoArticle: Article,
    val videoUrl: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.video_rocket)
)

