package com.web0zz.science_news.util

import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.data.model.Article

object FragmentUtil {

    interface OnClickDetail {
        val mainActivity: MainActivity

        fun onClickArticle(article: Article) {
            mainActivity.initHome(true)
            mainActivity.initDetail(false, article)
        }
    }

    interface OnClickOverview {
        val mainActivity: MainActivity

        fun onClickOverview(overviewId: Int) {
            mainActivity.initHome(true)
            mainActivity.initOverview(false, overviewId)
        }
    }
}