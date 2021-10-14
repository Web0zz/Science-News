package com.web0zz.science_news.util

import com.web0zz.science_news.data.model.Article

object FragmentUtil {
    interface ClickAction<T> {
        fun action(data: T)
    }

    interface OnClickDetail : ClickAction<Article> {
        override fun action(data: Article)
    }

    interface OnClickOverview : ClickAction<Int> {
        override fun action(data: Int)
    }

    interface OnClickBackOnDetail : ClickAction<Nothing?> {
        override fun action(data: Nothing?)
    }

    interface OnClickCloseOnOverview : ClickAction<Nothing?> {
        override fun action(data: Nothing?)
    }
}