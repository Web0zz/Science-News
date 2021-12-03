package com.web0zz.science_news.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.web0zz.science_news.data.model.Article

object FragmentUtil {
    fun Fragment.getFragmentNavController(@IdRes id: Int) = activity?.let {
        return@let Navigation.findNavController(it, id)
    }

    // Binding a function to a layout using data binding
    interface ClickAction<T> {
        fun action(data: T)
    }

    interface OnClickDetail : ClickAction<Int> {
        override fun action(data: Int)
    }

    interface OnClickFavorites : ClickAction<Nothing?> {
        override fun action(data: Nothing?)
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