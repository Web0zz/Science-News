package com.web0zz.science_news.adapter.detail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.view.detail.NormalBody
import com.web0zz.science_news.databinding.ViewNormalBodyTextBinding

class NormalBodyViewHolder(
    private val binding: ViewNormalBodyTextBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(normalBody: NormalBody) {
        binding.bodyText = normalBody.normalText
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): NormalBodyViewHolder {
            val view = ViewNormalBodyTextBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return NormalBodyViewHolder(view)
        }
    }
}