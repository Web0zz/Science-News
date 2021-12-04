package com.web0zz.science_news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavArgs
import androidx.navigation.NavController

abstract class BaseMainFragment<B : ViewDataBinding>(
    inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BaseFragment<B>(inflateLayout) {
    protected abstract val safeArgs: NavArgs?
    protected abstract val navController: NavController?

    open fun getArgumentsToVariable() {}

    open fun Menu.updateOptionsMenu() {}

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.updateOptionsMenu()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getArgumentsToVariable()
    }
}