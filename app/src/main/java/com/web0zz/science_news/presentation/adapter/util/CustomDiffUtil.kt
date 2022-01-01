package com.web0zz.science_news.presentation.adapter.util

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CustomDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}

fun <T> CustomDiffUtil<T>.calculateAndDispatch(adapter: RecyclerView.Adapter<*>) {
    DiffUtil.calculateDiff(this).dispatchUpdatesTo(adapter)
}