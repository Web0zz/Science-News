package com.web0zz.science_news.presentation.adapter.detail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.domain.model.view.detail.ContentImage
import com.web0zz.science_news.databinding.ViewContentImageBinding

class ContentImageViewHolder(
    private val binding: ViewContentImageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contentImage: ContentImage) {
        binding.imageUrl = contentImage.imageUrl
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): ContentImageViewHolder {
            val view = ViewContentImageBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ContentImageViewHolder(view)
        }
    }
}