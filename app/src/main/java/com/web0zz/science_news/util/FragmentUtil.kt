package com.web0zz.science_news.util

import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.data.model.Article

object FragmentUtil {
    interface ClickAction<T> {
        val mainActivity: MainActivity
        fun action(data: T?)
    }

    interface OnClickDetail : ClickAction<Article> {
        override fun action(data: Article?) {
            mainActivity.navigation.initHome(true)
            mainActivity.navigation.initDetail(false, data)
        }
    }

    interface OnClickOverview : ClickAction<Int> {
        override fun action(data: Int?) {
            mainActivity.navigation.initHome(true)
            mainActivity.navigation.initOverview(false, data)
        }
    }

    interface OnClickBackOnDetail : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.navigation.initDetail(true)
            mainActivity.navigation.initHome(false)
        }
    }

    interface OnClickCloseOnOverview : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.navigation.initOverview(true)
            mainActivity.navigation.initHome(false)
        }
    }
}