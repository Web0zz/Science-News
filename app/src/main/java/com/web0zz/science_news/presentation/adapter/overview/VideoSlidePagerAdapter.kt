package com.web0zz.science_news.presentation.adapter.overview

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VideoSlidePagerAdapter(
    videoFragment: Fragment,
    private val pageCount: Int,
    private val newVideoInstance: (Int) -> Fragment
) : FragmentStateAdapter(videoFragment) {
    override fun getItemCount(): Int = pageCount

    override fun createFragment(position: Int): Fragment = newVideoInstance(position)
}