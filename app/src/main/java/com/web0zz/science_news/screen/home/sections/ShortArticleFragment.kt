package com.web0zz.science_news.screen.home.sections


import android.os.Bundle
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.dummyData.newsList
import com.web0zz.science_news.databinding.ViewShortArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.SectionHandler
import kotlin.properties.Delegates


class ShortArticleFragment : BaseFragment<ViewShortArticleBinding>() {
    override fun getLayoutId() = R.layout.view_short_article

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

        fun newInstance(articleId: Int): ShortArticleFragment =
            ShortArticleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARTICLE_ID, articleId)
                }
            }
    }
}