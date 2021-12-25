package com.web0zz.science_news.presentation.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.adapter.home.body.TallExtraArticleRecyclerAdapter
import com.web0zz.science_news.domain.model.view.sections.TallLightArticle
import com.web0zz.science_news.databinding.ViewTallLightArticleBinding
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class TallExtraMainArticleViewHolder(
    private val binding: ViewTallLightArticleBinding,
    private val onArticleClicked: ClickActionTypes.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tallLight: TallLightArticle) {
        val animationView = AnimationUtils.loadAnimation(
            binding.root.context,
            R.anim.recyclerview_article_section_anim
        )
        binding.root.startAnimation(animationView)

        binding.viewTallExtraRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = TallExtraArticleRecyclerAdapter(tallLight.articleList, onArticleClicked)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: ClickActionTypes.OnClickDetail
        ): TallExtraMainArticleViewHolder {
            val view = ViewTallLightArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallExtraMainArticleViewHolder(view, onArticleClicked)
        }
    }
}