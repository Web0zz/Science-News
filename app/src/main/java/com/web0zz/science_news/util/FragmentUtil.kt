package com.web0zz.science_news.util

import com.web0zz.science_news.MainActivity

object FragmentUtil {

    interface OnClickDetail {
        val mainActivity: MainActivity

        fun onClick(articleId: Int) {
            mainActivity.initHome(true)
            mainActivity.initDetail(false, articleId)
        }
    }
}