package com.web0zz.science_news.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    protected lateinit var activityBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = getViewBinding()
        setContentView(activityBinding.root)
        initUi()
    }

    abstract fun getViewBinding(): B

    abstract fun initUi()
}