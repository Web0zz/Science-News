package com.web0zz.science_news.adapter.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.adapter.overview.viewholder.OverviewItemViewHolder
import com.web0zz.science_news.data.model.Overview
import com.web0zz.science_news.util.FragmentUtil

class OverviewItemsRecyclerAdapter(
    private val overviewList: List<Overview>,
    private val onClickOverview: FragmentUtil.OnClickOverview
) : RecyclerView.Adapter<OverviewItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewItemViewHolder {
        return OverviewItemViewHolder.create(parent, onClickOverview)
    }

    override fun onBindViewHolder(holder: OverviewItemViewHolder, position: Int) {
        holder.bind(overviewList[position])
    }

    override fun getItemCount() = overviewList.size
}