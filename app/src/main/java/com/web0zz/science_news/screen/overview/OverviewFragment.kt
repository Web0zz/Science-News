package com.web0zz.science_news.screen.overview

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.adapter.home.sections.VideoSlidePagerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.FragmentOverviewBinding
import com.web0zz.science_news.screen.overview.video.VideoFragment
import com.web0zz.science_news.util.AdapterUtil
import kotlin.properties.Delegates

class OverviewFragment : BaseFragment<FragmentOverviewBinding>(FragmentOverviewBinding::inflate) {
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

        val pagerAdapter =
            VideoSlidePagerAdapter(this, NUM_PAGES)
            { VideoFragment.newInstance(selectedOverviewId, it) }
        viewPager.adapter = pagerAdapter
        viewPager.setPageTransformer(AdapterUtil.DepthPageTransformer())

        fragmentDataBinding.dotsIndicator.setViewPager2(viewPager)

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onMoveBack()
                }
            })
    }

    fun onMoveBack() {
        if (viewPager.currentItem == 0) {
            val mainActivity = (requireActivity() as MainActivity)

            mainActivity.initOverview(true)
            mainActivity.initHome(false)
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
}