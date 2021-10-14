package com.web0zz.science_news

import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.navigation.MainNavigation

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override val navigation: MainNavigation by lazy {
        MainNavigation(supportFragmentManager, activityBinding.hostFrameLayout.id)
    }

    override fun initUi() = navigation.initSplash()
}