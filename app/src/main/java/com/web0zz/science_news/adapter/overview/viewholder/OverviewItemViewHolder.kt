package com.web0zz.science_news.adapter.overview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.databinding.ViewOverviewArticleItemBinding
import com.web0zz.science_news.util.FragmentUtil

class OverviewItemViewHolder(
    private val binding: ViewOverviewArticleItemBinding,
    private val onClickOverview: FragmentUtil.OnClickOverview
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(overview: Overview) {
        binding.overviewItem = overview
        binding.onClickOverview = onClickOverview
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickOverview: FragmentUtil.OnClickOverview
        ): OverviewItemViewHolder {
            val view = ViewOverviewArticleItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return OverviewItemViewHolder(view, onClickOverview)
        }
    }
}