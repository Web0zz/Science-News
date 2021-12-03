package com.web0zz.science_news.screen.overview

import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.home.sections.VideoSlidePagerAdapter
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.FragmentOverviewBinding
import com.web0zz.science_news.screen.overview.video.VideoFragment
import com.web0zz.science_news.util.AdapterUtil
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController
import kotlin.properties.Delegates

class OverviewFragment :
    BaseMainFragment<FragmentOverviewBinding>(FragmentOverviewBinding::inflate) {
    override val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }
    override val safeArgs: OverviewFragmentArgs by navArgs()

    private var selectedOverviewId by Delegates.notNull<Int>()
    private lateinit var selectedOverview: Overview
    private lateinit var viewPager2: ViewPager2

    override fun getArgumentsToVariable() {
        selectedOverviewId = safeArgs.overviewId
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

    override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = onMoveBack()
        }

    override fun handleBackPressed() {
        backPressedCallback?.let { requireActivity().onBackPressedDispatcher.addCallback(this, it) }
    }

    private fun closeOverview() = object : FragmentUtil.OnClickCloseOnOverview {
        override fun action(data: Nothing?) {
            navController?.popBackStack()
        }
    }

    // Only, move back if the user on the first viewpager item
    fun onMoveBack() {
        if (viewPager2.currentItem == 0) {
            closeOverview().action(null)
        } else {
            viewPager2.currentItem = --viewPager2.currentItem
        }
    }

    companion object {
        private const val NUM_PAGES = 5
    }

    private fun getSelectedOverview(id: Int) = DummyData.overviewList[id]
}