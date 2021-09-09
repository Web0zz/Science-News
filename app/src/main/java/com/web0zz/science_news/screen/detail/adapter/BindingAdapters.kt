package com.web0zz.science_news.screen.detail.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["date", "author"], requireAll = true)
    fun TextView.setDateAuthorText(date: String, author: String) {
        val dateAuthor = "$date • $author"
        this.text = dateAuthor
    }
}