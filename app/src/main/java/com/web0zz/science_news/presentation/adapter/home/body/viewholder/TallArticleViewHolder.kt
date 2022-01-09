package com.web0zz.science_news.presentation.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.domain.model.view.sections.TallArticle
import com.web0zz.science_news.databinding.ViewTallArticleBinding
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import com.web0zz.science_news.util.setSaveButton
import com.web0zz.science_news.util.shareArticleLink

class TallArticleViewHolder(
    private val binding: ViewTallArticleBinding,
    private val onArticleClicked: ClickActionTypes.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tall: TallArticle) {
        binding.article = tall.article
        binding.onClickDetail = onArticleClicked

        binding.tallShareImageButton.setOnClickListener {
            it.context.shareArticleLink(tall.article.shareLink)
        }

        binding.tallSaveImageButton.apply {
            setSaveButton(tall.article.isSaved)
            setOnClickListener {
                when (tall.article.isSaved) {
                    true -> {
                        setSaveButton(false)
                        tall.article.isSaved = false
                        Toast.makeText(context, "Article Unsaved", Toast.LENGTH_SHORT).show()
                    }
                    false -> {
                        setSaveButton(true)
                        tall.article.isSaved = true
                        Toast.makeText(context, "Article Saved", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        val animationView = AnimationUtils.loadAnimation(
            binding.root.context,
            R.anim.recyclerview_article_section_anim
        )
        binding.root.startAnimation(animationView)
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onArticleClicked: ClickActionTypes.OnClickDetail
        ): TallArticleViewHolder {
            val view = ViewTallArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return TallArticleViewHolder(view, onArticleClicked)
        }
    }
}