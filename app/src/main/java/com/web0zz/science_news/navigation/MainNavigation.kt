package com.web0zz.science_news.navigation

import androidx.fragment.app.FragmentManager
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.HomeFragment
import com.web0zz.science_news.screen.overview.OverviewFragment
import com.web0zz.science_news.screen.splash.SplashFragment

class MainNavigation(
    manager: FragmentManager,
    private val binding: ActivityMainBinding
) {
    private val navigator = CommonFragmentManager(manager)

    // Responsible with waking up the Splash Screen Fragment, or remove.
    fun initSplash(willDelete: Boolean) {
        navigator.apply {
            decideAction(
                willDelete,
                onTrue = { destroyActiveMainFragment() },
                onFalse = {
                    addFragment(
                        binding.hostFrameLayout.id,
                        SplashFragment::newInstance
                    )
                }
            )
        }
    }

    // Responsible with waking up the Article Fragments, or remove.
    fun initHome(willDelete: Boolean) {
        navigator.apply {
            decideAction(
                willDelete,
                onTrue = { destroyActiveMainFragment() },
                onFalse = {
                    addFragment(binding.hostFrameLayout.id, HomeFragment::newInstance)
                }
            )
        }
    }

    // Responsible with waking up the Detail Fragment, or remove.
    fun initDetail(willDelete: Boolean, article: Article? = null) {
        navigator.apply {
            decideAction(
                willDelete,
                onTrue = { destroyActiveMainFragment() },
                onFalse = {
                    addFragment(binding.hostFrameLayout.id) {
                        DetailFragment.newInstance(article!!)
                    }
                }
            )
        }
    }

    // Responsible with waking up the OverviewFragment, or remove.
    fun initOverview(willDelete: Boolean, overviewId: Int? = null) {
        navigator.apply {
            decideAction(
                willDelete,
                onTrue = { destroyActiveMainFragment() },
                onFalse = {
                    addFragment(binding.hostFrameLayout.id) {
                        OverviewFragment.newInstance(overviewId!!)
                    }
                }
            )
        }
    }
}