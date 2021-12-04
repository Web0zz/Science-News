package com.web0zz.science_news.adapter.favorites

/*
TODO coming soon

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.adapter.home.body.viewholder.ShortArticleViewHolder
import com.web0zz.science_news.adapter.home.body.viewholder.TallArticleViewHolder
import com.web0zz.science_news.adapter.home.body.viewholder.TallLightArticleViewHolder
import com.web0zz.science_news.data.model.view.sections.ArticleItem
import com.web0zz.science_news.data.model.view.sections.ShortArticle
import com.web0zz.science_news.data.model.view.sections.TallArticle
import com.web0zz.science_news.data.model.view.sections.TallLightArticle
import com.web0zz.science_news.util.FragmentUtil

class FavoritesRecyclerAdapter(
    private val items: List<ArticleItem>,
    // TODO add navigation click event
    private val onArticleClicked: FragmentUtil.OnClickDetail
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int) = items[position].getType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ArticleItem.Type.SHORT_ARTICLE.ordinal -> ShortArticleViewHolder.create(
                parent,
                onArticleClicked
            )
            ArticleItem.Type.TALL_ARTICLE.ordinal -> TallArticleViewHolder.create(
                parent,
                onArticleClicked
            )
            ArticleItem.Type.TALL_LIGHT_ARTICLE.ordinal -> TallLightArticleViewHolder.create(
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
}*/
