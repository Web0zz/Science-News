package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.ShortArticle
import com.web0zz.science_news.databinding.ViewShortArticleBinding

class ShortArticleViewHolder(
    private val binding: ViewShortArticleBinding,
    onArticleClicked: (Article) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(short: ShortArticle) {}

    companion object {
        fun create(parent: ViewGroup, onArticleClicked: (Article) -> Unit): ShortArticleViewHolder {
            val view = ViewShortArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ShortArticleViewHolder(view, onArticleClicked)
        }
    }
}
