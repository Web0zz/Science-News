package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.model.view.TallLightArticle
import com.web0zz.science_news.databinding.ViewTallLightArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class TallLightArticleViewHolder(
    private val binding: ViewTallLightArticleBinding,
    private val onArticleClicked: FragmentUtil.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tallLight: TallLightArticle) {
        binding.articleList = tallLight.articleList
        binding.onClickDetail = onArticleClicked
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: FragmentUtil.OnClickDetail
        ): TallLightArticleViewHolder {
            val view = ViewTallLightArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallLightArticleViewHolder(view, onArticleClicked)
        }
    }
}