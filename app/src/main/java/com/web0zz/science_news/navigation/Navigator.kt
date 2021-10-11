package com.web0zz.science_news.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.web0zz.science_news.util.ActivityUtil.makeTransaction

class Navigator(
    private val activity: AppCompatActivity
) {
    private val fragmentList: MutableList<Fragment> = mutableListOf()

    fun addFragment(
        @IdRes layoutIdRes: Int,
        fragment: () -> Fragment,
    ) = activity.makeTransaction {
        add(layoutIdRes, fragment().also { fragmentList.add(it) })
    }

    private fun removeFragments(
        fragment: Fragment
    ) = activity.makeTransaction {
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