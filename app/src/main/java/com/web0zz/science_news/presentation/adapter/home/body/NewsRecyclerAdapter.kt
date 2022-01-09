package com.web0zz.science_news.presentation.adapter.home.body

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.adapter.home.body.viewholder.OverviewArticleViewHolder
import com.web0zz.science_news.presentation.adapter.home.body.viewholder.ShortArticleViewHolder
import com.web0zz.science_news.presentation.adapter.home.body.viewholder.TallArticleViewHolder
import com.web0zz.science_news.presentation.adapter.home.body.viewholder.TallExtraMainArticleViewHolder
import com.web0zz.science_news.domain.model.view.sections.ArticleItem
import com.web0zz.science_news.domain.model.ContentType.*
import com.web0zz.science_news.domain.model.News
import com.web0zz.science_news.domain.model.view.sections.ShortArticle
import com.web0zz.science_news.domain.model.view.sections.TallArticle
import com.web0zz.science_news.domain.model.view.sections.TallLightArticle
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class NewsRecyclerAdapter(
    private val onArticleClicked: ClickActionTypes.OnClickDetail,
    private val onOverviewClicked: ClickActionTypes.OnClickOverview
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun getItemViewType(position: Int) = differ.currentList[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            OVERVIEW_ARTICLE.ordinal -> OverviewArticleViewHolder.create(parent, onOverviewClicked)
            SHORT_ARTICLE.ordinal -> ShortArticleViewHolder.create(parent, onArticleClicked)
            TALL_ARTICLE.ordinal -> TallArticleViewHolder.create(parent, onArticleClicked)
            TALL_LIGHT_ARTICLE.ordinal -> TallExtraMainArticleViewHolder.create(
                parent,
                onArticleClicked
            )
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OverviewArticleViewHolder -> holder.bind()
            is ShortArticleViewHolder -> holder.bind(differ.currentList[position] as ShortArticle)
            is TallArticleViewHolder -> holder.bind(differ.currentList[position] as TallArticle)
            is TallExtraMainArticleViewHolder -> holder.bind(differ.currentList[position] as TallLightArticle)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun getItemCount() = differ.currentList.size

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticleItem>() {
            override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem) = oldItem == newItem
            override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem) = oldItem.itemId == newItem.itemId
        }
    }
}

