package com.web0zz.science_news.presentation.base

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util

abstract class BasePlayerFragment<B : ViewDataBinding>(
    inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BaseSimpleFragment<B>(inflateLayout) {
    private var player: ExoPlayer? = null
    protected abstract var playerView: PlayerView
    protected abstract var playVideoUri: Uri

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private val playbackStateListener: Player.Listener by lazy {
        playbackStateListener()
    }

    open fun whenPlayerStateIdle() {}
    open fun whenPlayerStateBuffering() {}
    open fun whenPlayerStateReady() {}
    open fun whenPlayerStateEnded() {}

    protected open fun playbackStateListener() = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                ExoPlayer.STATE_IDLE -> whenPlayerStateIdle()
                ExoPlayer.STATE_BUFFERING -> whenPlayerStateBuffering()
                ExoPlayer.STATE_READY -> whenPlayerStateReady()
                ExoPlayer.STATE_ENDED -> whenPlayerStateEnded()
            }
        }
    }

    protected open fun initializePlayer() {
        player = ExoPlayer.Builder(requireContext())
            .build()
            .also { exoPlayer ->
                playerView.player = exoPlayer
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.addListener(playbackStateListener)
                val mediaItem = MediaItem.fromUri(playVideoUri)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()
            }
    }

    protected open fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentMediaItemIndex
            playWhenReady = this.playWhenReady
            removeListener(playbackStateListener)
            release()
        }
        player = null
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
        player?.play()
    }

    override fun initPause() {
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
        player?.pause()
    }

    override fun initStop() {
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
        player?.release()
    }
}