package com.web0zz.science_news.screen.home.sections

import android.os.Bundle
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.model.newsList
import com.web0zz.science_news.databinding.ViewTallArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.SectionHandler
import kotlin.properties.Delegates

class TallArticleFragment : BaseFragment<ViewTallArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_article

    private var articleId by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        articleId = this.getInt(ARTICLE_ID)
    }

    override fun initUi() {
        fragmentDataBinding.sectionHandler =
            SectionHandler(newsList[articleId], (activity as MainActivity))
    }

    companion object {
        private const val ARTICLE_ID = "articleId"

        fun newInstance(articleId: Int): TallArticleFragment =
            TallArticleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARTICLE_ID, articleId)
                }
            }
    }
}