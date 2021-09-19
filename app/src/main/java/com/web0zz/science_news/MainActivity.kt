package com.web0zz.science_news

import androidx.fragment.app.Fragment
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.sections.OverviewArticleFragment
import com.web0zz.science_news.screen.home.sections.ShortArticleFragment
import com.web0zz.science_news.screen.home.sections.TallArticleFragment
import com.web0zz.science_news.screen.home.sections.TallLightArticleFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment
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
                    fragmentList.removeAt(0)
                }
                false -> {
                    fragmentList.add(SplashFragment.newInstance())
                    this.add(activityBinding.splashFrameLayout.id, fragmentList.first())
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

                    // Wakes up the Tall Article Section fragment.
                    this.add(
                        activityBinding.tallArticleFrameLayout1.id,
                        TallArticleFragment.newInstance(0).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.tallArticleFrameLayout2.id,
                        TallArticleFragment.newInstance(1).also { fragmentList.add(it) })

                    // Wakes up the Short Article Section fragment.
                    this.add(
                        activityBinding.shortArticleFrameLayout1.id,
                        ShortArticleFragment.newInstance(2).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout2.id,
                        ShortArticleFragment.newInstance(3).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout3.id,
                        ShortArticleFragment.newInstance(4).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout4.id,
                        ShortArticleFragment.newInstance(5).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout5.id,
                        ShortArticleFragment.newInstance(6).also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout6.id,
                        ShortArticleFragment.newInstance(7).also { fragmentList.add(it) })

                    // Wakes up the Tall Light Article Section fragment.
                    this.add(
                        activityBinding.tallDarkArticleFrameLayout.id,
                        TallLightArticleFragment.newInstance(8, 9, 10, 11)
                            .also { fragmentList.add(it) })
                }
            }
        }
    }

    // Responsible with waking up the Detail Fragment, or remove.
    fun initDetail(willDelete: Boolean, articleId: Int? = null) {
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
                        activityBinding.detailFrameLayout.id,
                        DetailFragment.newInstance(articleId!!).also { fragmentList.add(it) })
                }
            }
        }
    }
}