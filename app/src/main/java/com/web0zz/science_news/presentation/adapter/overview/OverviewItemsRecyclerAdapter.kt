package com.web0zz.science_news.presentation.adapter.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.presentation.adapter.overview.viewholder.OverviewItemViewHolder
import com.web0zz.science_news.domain.model.Overview
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class OverviewItemsRecyclerAdapter(
    private val overviewList: List<Overview>,
    private val onClickOverview: ClickActionTypes.OnClickOverview
) : RecyclerView.Adapter<OverviewItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewItemViewHolder {
        return OverviewItemViewHolder.create(parent, onClickOverview)
    }

    override fun onBindViewHolder(holder: OverviewItemViewHolder, position: Int) {
        holder.bind(overviewList[position])
    }

    override fun getItemCount() = overviewList.size
}