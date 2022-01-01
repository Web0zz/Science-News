package com.web0zz.science_news.presentation.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.domain.model.view.sections.ShortArticle
import com.web0zz.science_news.databinding.ViewShortArticleBinding
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import com.web0zz.science_news.util.setSaveButton
import com.web0zz.science_news.util.shareArticleLink

class ShortArticleViewHolder(
    private val binding: ViewShortArticleBinding,
    private val onArticleClicked: ClickActionTypes.OnClickDetail,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(short: ShortArticle) {
        binding.article = short.article
        binding.onClickDetail = onArticleClicked

        binding.shortShareImageButton.setOnClickListener {
            it.context.shareArticleLink(short.article.shareLink)
        }

        binding.shortSaveImageButton.apply {
            setSaveButton(short.article.isSaved)
            setOnClickListener {
                when (short.article.isSaved) {
                    true -> {
                        setSaveButton(false)
                        short.article.isSaved = false
                        Toast.makeText(context, "Article Unsaved", Toast.LENGTH_SHORT).show()
                    }
                    false -> {
                        setSaveButton(true)
                        short.article.isSaved = true
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
        ): ShortArticleViewHolder {
            val view = ViewShortArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ShortArticleViewHolder(view, onArticleClicked)
        }
    }
}
