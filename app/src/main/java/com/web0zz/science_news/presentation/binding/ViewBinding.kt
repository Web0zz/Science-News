package com.web0zz.science_news.presentation.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object ViewBinding {
    @JvmStatic
    @BindingAdapter("LoadImage")
    fun ImageView.bindLoadImage(article_image_url: String) {
        Glide.with(this.context)
            .load(article_image_url)
            .apply(RequestOptions().override(1000, 650))
            .into(this)
    }

    @JvmStatic
    @BindingAdapter(value = ["LoadRoundedImage", "CornerRadius", "Width", "Height"])
    fun ImageView.bindLoadRoundedImage(
        article_image_url: String,
        radius: Int,
        width: Int,
        height: Int,
    ) {
        Glide.with(this.context)
            .load(article_image_url)
            .apply(RequestOptions().override(width, height).transform(RoundedCorners(radius)))
            .into(this)
    }

    @JvmStatic
    @BindingAdapter(value = ["date", "author"], requireAll = true)
    fun TextView.setDateAuthorText(date: String, author: String) {
        val dateAuthor = "$date • $author"
        this.text = dateAuthor
    }
}