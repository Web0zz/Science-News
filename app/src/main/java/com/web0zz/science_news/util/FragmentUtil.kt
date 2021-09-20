package com.web0zz.science_news.util

import com.web0zz.science_news.MainActivity

object FragmentUtil {

    interface OnClickDetail {
        val mainActivity: MainActivity

        fun onClickArticle(articleId: Int) {
            mainActivity.initHome(true)
            mainActivity.initDetail(false, articleId)
        }
    }
}