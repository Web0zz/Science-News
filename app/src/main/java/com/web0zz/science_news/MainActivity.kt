package com.web0zz.science_news

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.screen.detail.DetailFragment
import com.web0zz.science_news.screen.home.sections.OverviewArticleFragment
import com.web0zz.science_news.screen.home.sections.ShortArticleFragment
import com.web0zz.science_news.screen.home.sections.TallArticleFragment
import com.web0zz.science_news.screen.home.sections.TallDarkArticleFragment
import com.web0zz.science_news.screen.splash.SplashFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun initUi() {
        initSplash(false)
    }

    /**
     *   Responsible with waking up the Splash Screen Fragment, or remove.
     */
    fun initSplash(willDelete: Boolean) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    this.remove(fragmentList.first())
                    fragmentList.removeAt(0)
                }
                false -> {
                    fragmentList.add(SplashFragment.newInstance())
                    this.add(R.id.splash_frameLayout, fragmentList.first())
                }
            }
        }
    }

    /**
     *  Responsible with waking up the Article Fragments, or remove.
     */
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
                    this.add(
                        activityBinding.overviewFrameLayout.id,
                        OverviewArticleFragment.newInstance().also { fragmentList.add(it) })

                    this.add(
                        activityBinding.tallArticleFrameLayout1.id,
                        TallArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.tallArticleFrameLayout2.id,
                        TallArticleFragment.newInstance().also { fragmentList.add(it) })

                    this.add(
                        activityBinding.shortArticleFrameLayout1.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout2.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout3.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout4.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout5.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })
                    this.add(
                        activityBinding.shortArticleFrameLayout6.id,
                        ShortArticleFragment.newInstance().also { fragmentList.add(it) })

                    this.add(
                        activityBinding.tallDarkArticleFrameLayout.id,
                        TallDarkArticleFragment.newInstance().also { fragmentList.add(it) })
                }
            }
        }
    }

    /**
     *  Responsible with waking up the Detail Fragment, or remove.
     */
    fun initDetail(willDelete: Boolean, articleId: Int? = null) {
        this.makeTransaction {
            when (willDelete) {
                true -> {
                    this.remove(fragmentList.removeAt(0))
                    fragmentList.clear()
                }
                false -> {
                    this.add(
                        R.id.detail_frameLayout,
                        DetailFragment.newInstance(articleId!!).also { fragmentList.add(it) })
                }
            }
        }
    }

    private fun makeTransaction(
        config: (FragmentTransaction.() -> Unit)? = null
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        config?.let { config(transaction) }
        transaction.commit()
    }
}