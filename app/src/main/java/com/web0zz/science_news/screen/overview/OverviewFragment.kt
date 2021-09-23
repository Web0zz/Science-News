package com.web0zz.science_news.screen.overview

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.FragmentOverviewBinding
import com.web0zz.science_news.screen.overview.video.VideoFragment
import kotlin.properties.Delegates

class OverviewFragment : BaseFragment<FragmentOverviewBinding>() {
    override fun getLayoutId() = R.layout.fragment_overview

    private var selectedOverviewId by Delegates.notNull<Int>()
    private lateinit var selectedOverview: Overview
    private lateinit var viewPager: ViewPager2

    override fun Bundle.getArgumentsToVariable() {
        selectedOverviewId = this.getInt(OVERVIEW_ID)
        selectedOverview = getSelectedOverview(selectedOverviewId)
    }

    override fun initUi() {
        fragmentDataBinding.overview = selectedOverview
        viewPager = fragmentDataBinding.viewPager2

        val pagerAdapter = VideoSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onMoveBack()
                }
            })
    }

    fun onMoveBack() {
        if(viewPager.currentItem == 0) {
            // TODO move back from video screen
        } else {
            viewPager.currentItem = --viewPager.currentItem
        }
    }


    companion object {
        private const val OVERVIEW_ID = "overviewId"
        private const val NUM_PAGES = 5

        fun newInstance(overviewID: Int): OverviewFragment =
            OverviewFragment().apply {
                arguments = Bundle().apply {
                    putInt(OVERVIEW_ID, overviewID)
                }
            }
    }

    private fun getSelectedOverview(id: Int) = DummyData.overviewList[id]

    private inner class VideoSlidePagerAdapter(videoFragment: Fragment) : FragmentStateAdapter(videoFragment) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = VideoFragment.newInstance(selectedOverviewId, position)
    }
}