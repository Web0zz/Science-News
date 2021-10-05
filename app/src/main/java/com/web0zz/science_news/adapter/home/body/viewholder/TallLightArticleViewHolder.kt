package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.TallLightArticle
import com.web0zz.science_news.databinding.ViewTallLightArticleBinding

class TallLightArticleViewHolder(
    private val binding: ViewTallLightArticleBinding,
    onArticleClicked: (Article) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(short: TallLightArticle) {}

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: (Article) -> Unit
        ): TallLightArticleViewHolder {
            val view = ViewTallLightArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallLightArticleViewHolder(view, onArticleClicked)
        }
    }
}