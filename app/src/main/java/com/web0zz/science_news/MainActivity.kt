package com.web0zz.science_news

import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.navigation.MainNavigation

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    val navigation: MainNavigation by lazy {
        MainNavigation(supportFragmentManager, activityBinding)
    }

    override fun initUi() {
        navigation.initSplash(false)
    }
}