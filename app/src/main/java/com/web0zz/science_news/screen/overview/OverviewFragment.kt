package com.web0zz.science_news.screen.overview

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.web0zz.science_news.adapter.home.sections.VideoSlidePagerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.FragmentOverviewBinding
import com.web0zz.science_news.screen.overview.video.VideoFragment
import com.web0zz.science_news.util.AdapterUtil
import com.web0zz.science_news.util.FragmentUtil
import kotlin.properties.Delegates

class OverviewFragment : BaseFragment<FragmentOverviewBinding>(FragmentOverviewBinding::inflate) {
    private var selectedOverviewId by Delegates.notNull<Int>()
    private lateinit var selectedOverview: Overview
    private lateinit var viewPager2: ViewPager2

    override fun Bundle.getArgumentsToVariable() {
        selectedOverviewId = this.getInt(OVERVIEW_ID)
        selectedOverview = getSelectedOverview(selectedOverviewId)
    }

    override fun initUi() {
        fragmentDataBinding.overview = selectedOverview
        fragmentDataBinding.onClickClose = closeOverview()

        val pagerAdapter =
            VideoSlidePagerAdapter(this, NUM_PAGES)
            { VideoFragment.newInstance(selectedOverviewId, it) }

        viewPager2 = fragmentDataBinding.viewPager2

        viewPager2.adapter = pagerAdapter
        viewPager2.setPageTransformer(AdapterUtil.DepthPageTransformer())

        fragmentDataBinding.dotsIndicator.setViewPager2(viewPager2)
    }

    private fun closeOverview() = object : FragmentUtil.OnClickCloseOnOverview {
        override fun action(data: Nothing?) = parentFragmentManager.popBackStack()
    }

    fun onMoveBack() {
        if (viewPager2.currentItem == 0) {
            closeOverview().action(null)
        } else {
            viewPager2.currentItem = --viewPager2.currentItem
        }
    }

    override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = onMoveBack()
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