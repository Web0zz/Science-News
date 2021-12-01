package com.web0zz.science_news.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(
    private val inflateLayout: (LayoutInflater) -> B
) : AppCompatActivity() {
    private lateinit var activityDataBinding: B

    /*abstract val navigation: MainNavigation*/
    open fun initUi() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDataBinding = inflateLayout(layoutInflater)
        setContentView(activityDataBinding.root)

        initUi()
    }
}