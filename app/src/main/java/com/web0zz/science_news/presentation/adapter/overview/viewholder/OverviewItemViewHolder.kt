package com.web0zz.science_news.presentation.adapter.overview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.domain.model.Overview
import com.web0zz.science_news.databinding.ViewOverviewArticleItemBinding
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class OverviewItemViewHolder(
    private val binding: ViewOverviewArticleItemBinding,
    private val onClickOverview: ClickActionTypes.OnClickOverview
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(overview: Overview) {
        binding.overviewItem = overview
        binding.onClickOverview = onClickOverview
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickOverview: ClickActionTypes.OnClickOverview
        ): OverviewItemViewHolder {
            val view = ViewOverviewArticleItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return OverviewItemViewHolder(view, onClickOverview)
        }
    }
}