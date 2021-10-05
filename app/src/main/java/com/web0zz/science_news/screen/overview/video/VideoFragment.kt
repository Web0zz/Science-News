package com.web0zz.science_news.screen.overview.video

import android.os.Bundle
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.ShortVideo
import com.web0zz.science_news.databinding.ViewVideoOverviewBinding
import kotlin.properties.Delegates

class VideoFragment : BaseFragment<ViewVideoOverviewBinding>(ViewVideoOverviewBinding::inflate) {
    private var shortVideoId by Delegates.notNull<Int>()
    private var overviewId by Delegates.notNull<Int>()
    private var player: SimpleExoPlayer? = null
    private lateinit var shortVideo: ShortVideo

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private val playbackStateListener: Player.Listener = playbackStateListener()

    override fun Bundle.getArgumentsToVariable() {
        shortVideoId = this.getInt(CURRENT_OVERVIEW_ID)
        overviewId = this.getInt(CURRENT_VIDEO_ID)

        shortVideo = getShortVideos()
    }

    override fun initUi() {
        fragmentDataBinding.shortVideo = shortVideo
    }

    override fun initStart() {
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    override fun initResume() {
        if ((Util.SDK_INT < 24) || player == null) {
            initializePlayer()
        }
    }

    override fun initPause() {
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun initStop() {
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(requireContext())
            .build()
            .also { exoPlayer ->
                fragmentDataBinding.shortExoPlayer.player = exoPlayer
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.addListener(playbackStateListener)
                val mediaItem = MediaItem.fromUri(shortVideo.videoUrl)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()
            }
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            removeListener(playbackStateListener)
            release()
        }
        player = null
    }

    private fun playbackStateListener() = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            if (playbackState == ExoPlayer.STATE_READY) {
                fragmentDataBinding.videoGroup.visibility = View.VISIBLE
                fragmentDataBinding.loadingProgressBar.visibility = View.GONE
            }
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