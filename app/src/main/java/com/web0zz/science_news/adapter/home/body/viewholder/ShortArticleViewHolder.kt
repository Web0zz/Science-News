package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.data.model.view.sections.ShortArticle
import com.web0zz.science_news.databinding.ViewShortArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class ShortArticleViewHolder(
    private val binding: ViewShortArticleBinding,
    private val onArticleClicked: FragmentUtil.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(short: ShortArticle) {
        binding.article = short.article
        binding.onClickDetail = onArticleClicked

        val animationView = AnimationUtils.loadAnimation(
            binding.root.context,
            R.anim.recyclerview_article_section_anim
        )
        binding.root.startAnimation(animationView)
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: FragmentUtil.OnClickDetail
        ): ShortArticleViewHolder {
            val view = ViewShortArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ShortArticleViewHolder(view, onArticleClicked)
        }
    }
}
