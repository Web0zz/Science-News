package com.web0zz.science_news.screen.home.sections

import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.ViewTallArticleBinding

class TallArticleFragment : BaseFragment<ViewTallArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_article

    override fun initUi() {
        fragmentDataBinding.article = newsList[0]
    }

    companion object {
        fun newInstance(): TallArticleFragment {
            return TallArticleFragment()
        }
    }
}