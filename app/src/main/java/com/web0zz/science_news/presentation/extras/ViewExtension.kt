package com.web0zz.science_news.util

import android.widget.ImageButton
import com.web0zz.science_news.R

fun ImageButton.setSaveButton(isSaved: Boolean) {
    setImageResource(
        if (isSaved) R.drawable.ic_saved
        else R.drawable.ic_unsaved
    )
}