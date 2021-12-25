package com.web0zz.science_news.presentation.adapter.home.body

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.presentation.adapter.home.body.viewholder.TallExtraArticleViewHolder
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.extras.ClickActionTypes

class TallExtraArticleRecyclerAdapter(
    private val articleList: List<Article>,
    private val onClickDetail: ClickActionTypes.OnClickDetail
) : RecyclerView.Adapter<TallExtraArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TallExtraArticleViewHolder {
        return TallExtraArticleViewHolder.create(parent, onClickDetail)
    }

    override fun onBindViewHolder(holder: TallExtraArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount() = articleList.size
}