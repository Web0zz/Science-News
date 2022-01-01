package com.web0zz.science_news.presentation.adapter.favorite

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.adapter.favorite.viewholder.FavoriteArticleViewHolder
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class FavoritesRecyclerAdapter(
    private val items: List<Article>,
    private val onArticleClicked: ClickActionTypes.OnClickDetail
) : RecyclerView.Adapter<FavoriteArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteArticleViewHolder {
        return FavoriteArticleViewHolder.create(parent, onArticleClicked)
    }

    override fun onBindViewHolder(holder: FavoriteArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}