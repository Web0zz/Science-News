package com.web0zz.science_news.util

import android.content.Context
import android.content.Intent

object ActivityUtil {
    fun Context.shareArticleLink(shareLink: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Sharing URL")
            putExtra(Intent.EXTRA_TEXT, shareLink)
        }
        startActivity(shareIntent)
    }
}