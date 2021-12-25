package com.web0zz.science_news.presentation.screen.overview.video

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.google.android.exoplayer2.ui.PlayerView
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.base.BasePlayerFragment
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.domain.model.ShortVideo
import com.web0zz.science_news.databinding.ViewVideoOverviewBinding
import com.web0zz.science_news.presentation.screen.overview.OverviewFragmentDirections
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import kotlin.properties.Delegates

class VideoFragment :
    BasePlayerFragment<ViewVideoOverviewBinding>(ViewVideoOverviewBinding::inflate) {
    private val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private var shortVideoId by Delegates.notNull<Int>()
    private var overviewId by Delegates.notNull<Int>()
    private lateinit var shortVideo: ShortVideo

    override lateinit var playerView: PlayerView
    override lateinit var playVideoUri: Uri

    override fun Bundle.getArgumentsToVariableByBundle() {
        shortVideoId = this.getInt(CURRENT_VIDEO_ID)
        overviewId = this.getInt(CURRENT_OVERVIEW_ID)

        getShortVideos().apply {
            shortVideo = this
            playVideoUri = videoUrl
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

    private fun toArticleDetail() = object : ClickActionTypes.OnClickDetail {
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

    private fun getShortVideos() = DummyDataSource().overviewList[overviewId].videos[shortVideoId]
}