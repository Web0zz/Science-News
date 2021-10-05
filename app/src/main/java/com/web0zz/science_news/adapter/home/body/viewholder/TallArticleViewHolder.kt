package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.TallArticle
import com.web0zz.science_news.databinding.ViewTallArticleBinding

class TallArticleViewHolder(
    private val binding: ViewTallArticleBinding,
    onArticleClicked: (Article) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(short: TallArticle) {}

    companion object {
        fun create(parent: ViewGroup, onArticleClicked: (Article) -> Unit): TallArticleViewHolder {
            val view = ViewTallArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallArticleViewHolder(view, onArticleClicked)
        }
    }
}