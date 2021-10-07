package com.web0zz.science_news.adapter.detail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.view.detail.ShortDescription
import com.web0zz.science_news.databinding.ViewShortDescriptionTextBinding

class ShortDescriptionViewHolder(
    private val binding: ViewShortDescriptionTextBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(shortDescription: ShortDescription) {
        binding.shortDescriptionText = shortDescription.shortText
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): ShortDescriptionViewHolder {
            val view = ViewShortDescriptionTextBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ShortDescriptionViewHolder(view)
        }
    }
}