package com.web0zz.science_news.binding

import android.widget.ImageView
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
            .apply(RequestOptions().override(600, 450))
            .into(this)
    }

    @JvmStatic
    @BindingAdapter("LoadRoundedImage")
    fun ImageView.bindLoadRoundedImage(article_image_url: String) {
        Glide.with(this.context)
            .load(article_image_url)
            .apply(RequestOptions().override(1000, 650).transform(RoundedCorners(30)))
            .into(this)
    }

    @JvmStatic
    @BindingAdapter("LoadCircleImage")
    fun ImageView.bindLoadCircleImage(user_image_url: String) {
        Glide.with(this.context)
            .load(user_image_url)
            .apply(RequestOptions().circleCrop())
            .into(this)
    }
}