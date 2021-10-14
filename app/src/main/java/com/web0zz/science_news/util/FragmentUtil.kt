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
            mainActivity.navigation.initDetail(false, data)
        }
    }

    interface OnClickOverview : ClickAction<Int> {
        override fun action(data: Int?) {
            mainActivity.navigation.initOverview(false, data)
        }
    }

    // TODO make on back action
    interface OnClickBackOnDetail : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.supportFragmentManager.popBackStack()
        }
    }

    interface OnClickCloseOnOverview : ClickAction<Nothing> {
        override fun action(data: Nothing?) {
            mainActivity.supportFragmentManager.popBackStack()
        }
    }
}