package com.web0zz.science_news.util

import com.web0zz.science_news.MainActivity

object FragmentUtil {
    fun MainActivity.getIntoDetail(articleId: Int) {
        this.initHome(true)
        this.initDetail(false, articleId)
    }
}