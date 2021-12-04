package com.web0zz.science_news.adapter.home.body

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.adapter.home.body.viewholder.TallExtraArticleViewHolder
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.util.FragmentUtil

class TallExtraArticleRecyclerAdapter(
    private val articleList: List<Article>,
    private val onClickDetail: FragmentUtil.OnClickDetail
) : RecyclerView.Adapter<TallExtraArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TallExtraArticleViewHolder {
        return TallExtraArticleViewHolder.create(parent, onClickDetail)
    }

    override fun onBindViewHolder(holder: TallExtraArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount() = articleList.size
}