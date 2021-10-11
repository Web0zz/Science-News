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
    ) = manager.makeTransaction {
        add(layoutIdRes, fragment().also { fragmentList.add(it) })
    }

    private fun removeFragments(
        fragment: Fragment
    ) = manager.makeTransaction {
        this.remove(fragment)
    }

    fun destroyActiveMainFragment() = fragmentList.apply {
        removeFragments(first())
        clear()
    }

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