package com.web0zz.science_news.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.web0zz.science_news.util.ActivityUtil.makeTransaction

class CommonFragmentManager(
    private val manager: FragmentManager
) {
    private val fragmentList: MutableList<Fragment> = mutableListOf()

    fun addFragment(
        @IdRes layoutIdRes: Int,
        fragment: () -> Fragment,
    ) = manager.makeTransaction { add(layoutIdRes, fragment().also { fragmentList.add(it) }) }

    fun toFragmentWithoutBackstack(
        @IdRes layoutIdRes: Int,
        fragment: () -> Fragment
    ) = manager.makeTransaction { replace(layoutIdRes, fragment()) }

    fun toFragmentScreen(
        @IdRes layoutIdRes: Int,
        fragment: () -> Fragment
    ) = manager.makeTransaction {
        addToBackStack(null)
        replace(layoutIdRes, fragment())
    }

    fun toBack() = manager.popBackStack()

    private fun removeFragments(
        fragment: Fragment
    ) = manager.makeTransaction { remove(fragment) }

    fun destroyAllFragments() = fragmentList.apply {
        forEach { removeFragments(it) }
        clear()
    }

    fun decideAction(
        willDelete: Boolean,
        onTrue: () -> Unit,
        onFalse: () -> Unit
    ) = when (willDelete) {
        true -> onTrue()
        false -> onFalse()
    }
}