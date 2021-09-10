package com.web0zz.science_news.screen.detail.handler

import com.web0zz.science_news.MainActivity

object ActionHandler {
    @JvmStatic
    fun moveBack(activity: MainActivity) {
        activity.initDetail(true)
        activity.initHome(false)
    }
}