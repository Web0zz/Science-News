package com.web0zz.science_news.presentation.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.presentation.adapter.overview.OverviewItemsRecyclerAdapter
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class OverviewArticleViewHolder(
    private val binding: ViewOverviewArticleBinding,
    private val onClickOverview: ClickActionTypes.OnClickOverview
) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.overviewArticleRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = OverviewItemsRecyclerAdapter(DummyDataSource().overviewList, onClickOverview)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickOverview: ClickActionTypes.OnClickOverview
        ): OverviewArticleViewHolder {
            val view = ViewOverviewArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return OverviewArticleViewHolder(view, onClickOverview)
        }
    }
}