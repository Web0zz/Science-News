package com.web0zz.science_news.presentation.adapter.favorite

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.adapter.favorite.viewholder.FavoriteArticleViewHolder
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class FavoritesRecyclerAdapter(
    private val onArticleClicked: ClickActionTypes.OnClickDetail
) : RecyclerView.Adapter<FavoriteArticleViewHolder>() {
    val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteArticleViewHolder {
        return FavoriteArticleViewHolder.create(parent, onArticleClicked)
    }

    override fun onBindViewHolder(holder: FavoriteArticleViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article) = oldItem == newItem
            override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem.id == newItem.id
        }
    }
}