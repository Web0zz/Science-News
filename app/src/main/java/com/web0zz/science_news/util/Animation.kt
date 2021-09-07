package com.web0zz.science_news.util

import androidx.fragment.app.FragmentTransaction
import com.web0zz.science_news.R

fun FragmentTransaction.anim(): FragmentTransaction =
    this.setCustomAnimations(
        R.anim.slide_in,
        R.anim.fade_out
    )
