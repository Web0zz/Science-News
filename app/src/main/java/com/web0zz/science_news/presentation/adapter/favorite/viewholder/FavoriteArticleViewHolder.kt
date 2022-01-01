package com.web0zz.science_news.presentation.adapter.favorite.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.databinding.ViewFavoritesArticleItemBinding
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.view.sections.ShortArticle
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class FavoriteArticleViewHolder(
    private val binding: ViewFavoritesArticleItemBinding,
    private val onArticleClicked: ClickActionTypes.OnClickDetail
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.article = article
        binding.onClickDetail = onArticleClicked
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: ClickActionTypes.OnClickDetail
        ): FavoriteArticleViewHolder {
            val view = ViewFavoritesArticleItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return FavoriteArticleViewHolder(view, onArticleClicked)
        }
    }
}