package com.web0zz.science_news.util

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object ActivityUtil {

    fun FragmentManager.makeTransaction(
        action: (FragmentTransaction.() -> Unit)? = null,
    ) {
        val transaction = this.beginTransaction()
        action?.let { action(transaction) }
        transaction.commit()
    }
}