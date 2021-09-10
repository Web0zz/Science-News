package com.web0zz.science_news.screen.home.sections


import android.os.Bundle
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.ViewTallDarkArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.SectionHandler
import kotlin.properties.Delegates

private const val ARTICLE_ID_1 = "articleId1"
private const val ARTICLE_ID_2 = "articleId2"
private const val ARTICLE_ID_3 = "articleId3"
private const val ARTICLE_ID_4 = "articleId4"

class TallDarkArticleFragment : BaseFragment<ViewTallDarkArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_dark_article

    private var articleId1 by Delegates.notNull<Int>()
    private var articleId2 by Delegates.notNull<Int>()
    private var articleId3 by Delegates.notNull<Int>()
    private var articleId4 by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        articleId1 = this.getInt(ARTICLE_ID_1)
        articleId2 = this.getInt(ARTICLE_ID_2)
        articleId3 = this.getInt(ARTICLE_ID_3)
        articleId4 = this.getInt(ARTICLE_ID_4)
    }

    override fun initUi() {
        fragmentDataBinding.sectionHandler1 =
            SectionHandler(newsList[articleId1], (activity as MainActivity))
        fragmentDataBinding.sectionHandler2 =
            SectionHandler(newsList[articleId2], (activity as MainActivity))
        fragmentDataBinding.sectionHandler3 =
            SectionHandler(newsList[articleId3], (activity as MainActivity))
        fragmentDataBinding.sectionHandler4 =
            SectionHandler(newsList[articleId4], (activity as MainActivity))
    }

    companion object {
        fun newInstance(
            articleId1: Int,
            articleId2: Int,
            articleId3: Int,
            articleId4: Int,
        ): TallDarkArticleFragment {
            return TallDarkArticleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARTICLE_ID_1, articleId1)
                    putInt(ARTICLE_ID_2, articleId2)
                    putInt(ARTICLE_ID_3, articleId3)
                    putInt(ARTICLE_ID_4, articleId4)
                }
            }
        }
    }
}