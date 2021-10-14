package com.web0zz.science_news.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.web0zz.science_news.navigation.MainNavigation

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    protected lateinit var activityBinding: B
    abstract val navigation: MainNavigation

    abstract fun getViewBinding(): B

    open fun initUi() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = getViewBinding()
        setContentView(activityBinding.root)
        initUi()

        this.onBackPressedDispatcher.addCallback(this, initBackPressListener())
    }

    abstract fun initBackPressListener(): OnBackPressedCallback
}