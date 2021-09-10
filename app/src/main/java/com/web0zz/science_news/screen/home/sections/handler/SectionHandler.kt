package com.web0zz.science_news.screen.home.sections.handler

import android.view.View
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.data.Article

class SectionHandler(
    val article: Article,
    private val activity: MainActivity
) {
    fun getIntoDetail(view: View) {
        activity.initHome(true)
        activity.initDetail(false, article.id)
    }
}