package com.web0zz.science_news.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

object ActivityUtil {

    fun AppCompatActivity.makeTransaction(
        action: (FragmentTransaction.() -> Unit)? = null,
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        action?.let { action(transaction) }
        transaction.commit()
    }
}