package com.web0zz.science_news.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.HomeFragment
import com.web0zz.science_news.screen.overview.OverviewFragment
import com.web0zz.science_news.screen.splash.SplashFragment

class MainNavigation(
    manager: FragmentManager,
    @IdRes private val hostLayout: Int
) {
    private val navigator = CommonFragmentManager(manager)

    // Responsible with waking up the Splash Fragment.
    fun initSplash() = navigator.toFragmentScreen(hostLayout, SplashFragment::newInstance)

    // Responsible with waking up the Home Fragment.
    fun initHome() = navigator.toFragmentWithoutBackstack(hostLayout, HomeFragment::newInstance)

    // Responsible with waking up the Detail Fragment.
    fun initDetail(article: Article) =
        navigator.toFragmentScreen(hostLayout) { DetailFragment.newInstance(article) }

    // Responsible with waking up the Overview Fragment.
    fun initOverview(overviewId: Int) =
        navigator.toFragmentScreen(hostLayout) { OverviewFragment.newInstance(overviewId) }
}