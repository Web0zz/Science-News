package com.web0zz.science_news

import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.navigation.Navigator
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.body.HomeBodyFragment
import com.web0zz.science_news.screen.home.body.sections.OverviewArticleFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment
import com.web0zz.science_news.screen.overview.OverviewFragment
import com.web0zz.science_news.screen.splash.SplashFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private val navigator = Navigator(this)

    // It used to solve scrolling problem.
    // Problem: When moving to detail screen scroll position stays as like on home view.
    private var lastScrollPosition: Int = 0

    override fun initUi() {
        initSplash(false)
    }

    // Responsible with waking up the Splash Screen Fragment, or remove.
    fun initSplash(willDelete: Boolean) {
        navigator.decideAction(
            willDelete,
            onTrue = { navigator.destroyActiveMainFragment() },
            onFalse = {
                navigator.addFragment(
                    activityBinding.actionFrameLayout.id,
                    SplashFragment::newInstance
                )
            }
        )
    }

    // Responsible with waking up the Article Fragments, or remove.
    fun initHome(willDelete: Boolean) {
        navigator.decideAction(
            willDelete,
            onTrue = { navigator.apply { destroyAllFragments() } },
            onFalse = {
                navigator.apply {
                    addFragment(activityBinding.topBarFrameLayout.id, TopBarFragment::newInstance)
                    addFragment(activityBinding.overviewFrameLayout.id, OverviewArticleFragment::newInstance)
                    addFragment(activityBinding.articleViewsFrameLayout.id, HomeBodyFragment::newInstance)
                }
            }
        )
    }

    // Responsible with waking up the Detail Fragment, or remove.
    fun initDetail(willDelete: Boolean, article: Article? = null) {
        navigator.decideAction(
            willDelete,
            onTrue = {
                activityBinding.mainScrollView.scrollTo(0, lastScrollPosition)

                navigator.destroyActiveMainFragment()
            },
            onFalse = {
                lastScrollPosition = activityBinding.mainScrollView.scrollY
                activityBinding.mainScrollView.scrollTo(0, 0)

                navigator.addFragment(activityBinding.actionFrameLayout.id) {
                    DetailFragment.newInstance(article!!)
                }
            }
        )
    }

    // Responsible with waking up the OverviewFragment, or remove.
    fun initOverview(willDelete: Boolean, overviewId: Int? = null) {
        navigator.apply {
            decideAction(
                willDelete,
                onTrue = { destroyActiveMainFragment() },
                onFalse = {
                    addFragment(activityBinding.actionFrameLayout.id) {
                        OverviewFragment.newInstance(overviewId!!)
                    }
                }
            )
        }
    }
}