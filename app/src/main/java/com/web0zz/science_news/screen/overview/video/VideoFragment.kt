package com.web0zz.science_news.screen.overview.video

import android.os.Bundle
import android.view.View
import com.google.android.exoplayer2.ui.PlayerView
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BasePlayerFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.ShortVideo
import com.web0zz.science_news.databinding.ViewVideoOverviewBinding
import com.web0zz.science_news.screen.overview.OverviewFragmentDirections
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController
import kotlin.properties.Delegates

class VideoFragment :
    BasePlayerFragment<ViewVideoOverviewBinding>(ViewVideoOverviewBinding::inflate) {
    private val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }

    private var shortVideoId by Delegates.notNull<Int>()
    private var overviewId by Delegates.notNull<Int>()
    private lateinit var shortVideo: ShortVideo

    override lateinit var playerView: PlayerView
    override lateinit var playVideoUrl: String

    override fun Bundle.getArgumentsToVariableByBundle() {
        shortVideoId = this.getInt(CURRENT_OVERVIEW_ID)
        overviewId = this.getInt(CURRENT_VIDEO_ID)

        getShortVideos().apply {
            shortVideo = this
            playVideoUrl = videoUrl
        }
    }

    override fun initUi() {
        fragmentDataBinding.shortVideo = shortVideo
        fragmentDataBinding.onClickDetail = toArticleDetail()
        playerView = fragmentDataBinding.shortExoPlayer
    }

    override fun whenPlayerStateReady() {
        fragmentDataBinding.videoGroup.visibility = View.VISIBLE
        fragmentDataBinding.loadingProgressBar.visibility = View.GONE
    }

    private fun toArticleDetail() = object : FragmentUtil.OnClickDetail {
        override fun action(data: Int) {
            val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
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