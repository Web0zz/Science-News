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
            mainActivity.initHome(true)
            mainActivity.initDetail(false, data)
        }
    }

    interface OnClickOverview : ClickAction<Int> {
        override fun action(data: Int?) {
            mainActivity.initHome(true)
            mainActivity.initOverview(false, data)
        }
    }

    interface OnClickBackOnDetail : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.initDetail(true)
            mainActivity.initHome(false)
        }
    }

    interface OnClickCloseOnOverview : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.initOverview(true)
            mainActivity.initHome(false)
        }
    }
}