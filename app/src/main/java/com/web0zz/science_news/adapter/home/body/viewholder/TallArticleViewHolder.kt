package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.data.model.view.sections.TallArticle
import com.web0zz.science_news.databinding.ViewTallArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class TallArticleViewHolder(
    private val binding: ViewTallArticleBinding,
    private val onArticleClicked: FragmentUtil.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tall: TallArticle) {
        binding.article = tall.article
        binding.onClickDetail = onArticleClicked

        // TODO generic viewHolder will be handle animations
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
        ): TallArticleViewHolder {
            val view = ViewTallArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallArticleViewHolder(view, onArticleClicked)
        }
    }
}