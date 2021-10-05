package com.web0zz.science_news.adapter.home.body

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.adapter.home.body.viewholder.ShortArticleViewHolder
import com.web0zz.science_news.adapter.home.body.viewholder.TallArticleViewHolder
import com.web0zz.science_news.adapter.home.body.viewholder.TallLightArticleViewHolder
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.ArticleItem
import com.web0zz.science_news.data.model.view.ArticleItem.Type.*
import com.web0zz.science_news.data.model.view.ShortArticle
import com.web0zz.science_news.data.model.view.TallArticle
import com.web0zz.science_news.data.model.view.TallLightArticle

class BodyRecyclerAdapter(
    private var items: List<ArticleItem>,
    private val onArticleClicked: (Article) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int) = items[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SHORT_ARTICLE.ordinal -> ShortArticleViewHolder.create(parent, onArticleClicked)
            TALL_ARTICLE.ordinal -> TallArticleViewHolder.create(parent, onArticleClicked)
            TALL_LIGHT_ARTICLE.ordinal -> TallLightArticleViewHolder.create(
                parent,
                onArticleClicked
            )
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShortArticleViewHolder -> holder.bind(items[position] as ShortArticle)
            is TallArticleViewHolder -> holder.bind(items[position] as TallArticle)
            is TallLightArticleViewHolder -> holder.bind(items[position] as TallLightArticle)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun getItemCount() = items.size
}

