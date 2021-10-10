package com.web0zz.science_news

import androidx.fragment.app.Fragment
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.body.HomeBodyFragment
import com.web0zz.science_news.screen.home.body.sections.OverviewArticleFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment
import com.web0zz.science_news.screen.overview.OverviewFragment
import com.web0zz.science_news.screen.splash.SplashFragment
import com.web0zz.science_news.util.ActivityUtil.makeTransaction

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    // It used to solve scrolling problem.
    // Problem: When moving to detail screen scroll position stays as like on home view.
    private var lastScrollPosition: Int = 0

    override fun initUi() {
        initSplash(false)
    }

    // Responsible with waking up the Splash Screen Fragment, or remove.
    fun initSplash(willDelete: Boolean) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    this.remove(fragmentList.first())
                    fragmentList.clear()
                }
                false -> {
                    this.add(
                        activityBinding.actionFrameLayout.id,
                        SplashFragment.newInstance().also { fragmentList.add(it) }
                    )
                }
            }
        }
    }

    // Responsible with waking up the Article Fragments, or remove.
    fun initHome(willDelete: Boolean) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    fragmentList.forEach { fragment ->
                        this.remove(fragment)
                    }
                    fragmentList.clear()
                }
                false -> {
                    // Wakes up the Top bar fragment.
                    this.add(
                        activityBinding.topBarFrameLayout.id,
                        TopBarFragment.newInstance().also { fragmentList.add(it) })

                    // Wakes up the Overview fragment.
                    this.add(
                        activityBinding.overviewFrameLayout.id,
                        OverviewArticleFragment.newInstance().also { fragmentList.add(it) })

                    // Wakes up the Articles FrameLayout fragment.
                    this.add(
                        activityBinding.articleViewsFrameLayout.id,
                        HomeBodyFragment.newInstance().also { fragmentList.add(it) }
                    )
                }
            }
        }
    }

    // Responsible with waking up the Detail Fragment, or remove.
    fun initDetail(willDelete: Boolean, article: Article? = null) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    // Set last scroll position,
                    activityBinding.mainScrollView.scrollTo(0, lastScrollPosition)

                    this.remove(fragmentList.removeAt(0))
                    fragmentList.clear()
                }
                false -> {
                    // Get last scroll position and save it,
                    // Scroll layout to start.
                    lastScrollPosition = activityBinding.mainScrollView.scrollY
                    activityBinding.mainScrollView.scrollTo(0, 0)

                    this.add(
                        activityBinding.actionFrameLayout.id,
                        DetailFragment.newInstance(article!!).also { fragmentList.add(it) })
                }
            }
        }
    }

    // Responsible with waking up the OverviewFragment, or remove.
    fun initOverview(willDelete: Boolean, overviewId: Int? = null) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    this.remove(fragmentList.removeAt(0))
                    fragmentList.clear()
                }
                false -> {
                    this.add(
                        activityBinding.actionFrameLayout.id,
                        OverviewFragment.newInstance(overviewId!!).also { fragmentList.add(it) })
                }
            }
        }
    }
}