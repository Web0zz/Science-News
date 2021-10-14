package com.web0zz.science_news.adapter.home.body.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.ShortVideo
import com.web0zz.science_news.data.model.view.sections.ShortArticle
import com.web0zz.science_news.data.model.view.sections.TallArticle
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class OverviewArticleViewHolder(
    private val binding: ViewOverviewArticleBinding,
    private val onClickOverview: FragmentUtil.OnClickOverview
) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        DummyData.overviewList.let {
            it.forEach { overview ->
                overview.videos = listOf(
                    // TODO will declare values outside
                    ShortVideo(0, (DummyData.newsList[1] as TallArticle).article),
                    ShortVideo(1, (DummyData.newsList[2] as ShortArticle).article),
                    ShortVideo(2, (DummyData.newsList[3] as ShortArticle).article),
                    ShortVideo(3, (DummyData.newsList[4] as ShortArticle).article),
                    ShortVideo(4, (DummyData.newsList[5] as ShortArticle).article),
                )
            }
            binding.overviewListData = it
        }
        binding.onClickOverview = onClickOverview
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onClickOverview: FragmentUtil.OnClickOverview
        ): OverviewArticleViewHolder {
            val view = ViewOverviewArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return OverviewArticleViewHolder(view, onClickOverview)
        }
    }
}