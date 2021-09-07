package com.web0zz.science_news

import android.os.Bundle
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding
import com.web0zz.science_news.screen.splash.SplashFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)
    override fun getFrameLayoutID() = R.id.main_FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeTransaction(SplashFragment.newInstance())
    }
}