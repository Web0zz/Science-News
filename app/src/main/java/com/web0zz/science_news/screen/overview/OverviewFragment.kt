package com.web0zz.science_news.screen.overview

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.overview.VideoSlidePagerAdapter
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.FragmentOverviewBinding
import com.web0zz.science_news.screen.overview.video.VideoFragment
import com.web0zz.science_news.util.DepthPageTransformer
import com.web0zz.science_news.util.FragmentUtil
import kotlin.properties.Delegates

class OverviewFragment :
    BaseMainFragment<FragmentOverviewBinding>(FragmentOverviewBinding::inflate) {
    override val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    override val safeArgs: OverviewFragmentArgs by navArgs()

    private var selectedOverviewId by Delegates.notNull<Int>()
    private lateinit var selectedOverview: Overview
    private lateinit var viewPager2: ViewPager2

    private fun firstSetupLayout(onCreate: Boolean) {
        val navbar =
            requireActivity().findViewById<BottomNavigationView>(R.id.nav_bottomNavigationView)
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.main_toolbar)

        if (onCreate) {
            navbar.visibility = View.GONE
            toolbar.visibility = View.GONE
        } else {
            navbar.visibility = View.VISIBLE
            toolbar.visibility = View.VISIBLE
        }
    }

    override fun getArgumentsToVariable() {
        selectedOverviewId = safeArgs.overviewId
        selectedOverview = getSelectedOverview(selectedOverviewId)
    }

    override fun initUi() {
        firstSetupLayout(true)

        fragmentDataBinding.overview = selectedOverview
        fragmentDataBinding.onClickClose = closeOverview()

        val pagerAdapter =
            VideoSlidePagerAdapter(this, NUM_PAGES)
            { VideoFragment.newInstance(selectedOverviewId, it) }

        viewPager2 = fragmentDataBinding.viewPager2

        viewPager2.adapter = pagerAdapter
        viewPager2.setPageTransformer(DepthPageTransformer())

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
            firstSetupLayout(false)
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

    private fun getSelectedOverview(id: Int) = DummyDataSource().overviewList[id]
}