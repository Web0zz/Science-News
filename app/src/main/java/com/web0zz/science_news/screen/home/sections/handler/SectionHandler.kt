package com.web0zz.science_news.screen.home.sections.handler

import android.view.View
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.data.model.Article

class SectionHandler(
    val article: Article,
    private val activity: MainActivity,
) {
    /**
     *  View parameter must be here because data binding can't recognize this function without view parameter.
     */
    fun getIntoDetail(view: View) {
        activity.initHome(true)
        activity.initDetail(false, article.id)
    }
}