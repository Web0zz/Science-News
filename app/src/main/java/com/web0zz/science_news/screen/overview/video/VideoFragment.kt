package com.web0zz.science_news.screen.overview.video

import android.os.Bundle
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.databinding.ViewVideoOverviewBinding
import kotlin.properties.Delegates

class VideoFragment : BaseFragment<ViewVideoOverviewBinding>() {
    override fun getLayoutId() = R.layout.view_video_overview

    private var shortVideoId by Delegates.notNull<Int>()
    private var overviewId by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        shortVideoId = this.getInt(CURRENT_OVERVIEW_ID)
        overviewId = this.getInt(CURRENT_VIDEO_ID)
    }

    override fun initUi() {
        fragmentDataBinding.shortVideo = getShortVideos()
        // TODO will add video player
    }

    companion object {
        private const val CURRENT_OVERVIEW_ID = "overviewId"
        private const val CURRENT_VIDEO_ID = "shortId"

        fun newInstance(overviewId: Int, shortId: Int): VideoFragment =
            VideoFragment().apply {
                arguments = Bundle().apply {
                    putInt(CURRENT_OVERVIEW_ID, overviewId)
                    putInt(CURRENT_VIDEO_ID, shortId)
                }
            }
    }

    private fun getShortVideos() = DummyData.overviewList[overviewId].videos[shortVideoId]
}