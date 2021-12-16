package com.web0zz.science_news.util

object FragmentUtil {
    // Binding a function to a layout using data binding
    interface ClickAction<T> {
        fun action(data: T)
    }

    interface OnClickDetail : ClickAction<Int> {
        override fun action(data: Int)
    }

    interface OnClickOverview : ClickAction<Int> {
        override fun action(data: Int)
    }

    interface OnClickCloseOnOverview : ClickAction<Nothing?> {
        override fun action(data: Nothing?)
    }
}