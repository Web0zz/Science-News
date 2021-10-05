package com.web0zz.science_news.screen.home.sections

import android.os.Bundle
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData.newsList
import com.web0zz.science_news.databinding.ViewShortArticleBinding
import com.web0zz.science_news.util.FragmentUtil
import kotlin.properties.Delegates

class ShortArticleFragment :
    BaseFragment<ViewShortArticleBinding>(ViewShortArticleBinding::inflate) {
    private var articleId by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        articleId = this.getInt(ARTICLE_ID)
    }

    override fun initUi() {
        fragmentDataBinding.article = newsList[articleId]
        fragmentDataBinding.onClickDetail = object : FragmentUtil.OnClickDetail {
            override val mainActivity: MainActivity
                get() = (requireActivity() as MainActivity)
        }
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