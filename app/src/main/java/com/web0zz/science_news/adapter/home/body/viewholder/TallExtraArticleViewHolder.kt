package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ViewTallExtraArticleItemBinding
import com.web0zz.science_news.util.FragmentUtil

class TallExtraArticleViewHolder(
    private val binding: ViewTallExtraArticleItemBinding,
    private val onClickDetail: FragmentUtil.OnClickDetail
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.articleData = article
        binding.onClickDetail = onClickDetail
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickDetail: FragmentUtil.OnClickDetail
        ): TallExtraArticleViewHolder {
            val view = ViewTallExtraArticleItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallExtraArticleViewHolder(view, onClickDetail)
        }
    }
}