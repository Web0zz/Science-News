package com.web0zz.science_news.adapter.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.adapter.detail.viewholder.ContentImageViewHolder
import com.web0zz.science_news.adapter.detail.viewholder.NormalBodyViewHolder
import com.web0zz.science_news.adapter.detail.viewholder.ShortDescriptionViewHolder
import com.web0zz.science_news.data.model.view.detail.ContentImage
import com.web0zz.science_news.data.model.view.detail.DetailItem
import com.web0zz.science_news.data.model.view.detail.NormalBody
import com.web0zz.science_news.data.model.view.detail.ShortDescription

class DetailBodyRecyclerAdapter(
    private var items: List<DetailItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int) = items[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DetailItem.Type.CONTENT_IMAGE.ordinal -> ContentImageViewHolder.create(parent)
            DetailItem.Type.NORMAL_BODY.ordinal -> NormalBodyViewHolder.create(parent)
            DetailItem.Type.SHORT_DESCRIPTION.ordinal -> ShortDescriptionViewHolder.create(parent)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContentImageViewHolder -> holder.bind(items[position] as ContentImage)
            is NormalBodyViewHolder -> holder.bind(items[position] as NormalBody)
            is ShortDescriptionViewHolder -> holder.bind(items[position] as ShortDescription)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun getItemCount() = items.size
}