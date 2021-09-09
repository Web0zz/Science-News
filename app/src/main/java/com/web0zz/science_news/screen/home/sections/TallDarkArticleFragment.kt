package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.ViewTallDarkArticleBinding

class TallDarkArticleFragment : BaseFragment<ViewTallDarkArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_dark_article

    override fun initUi() {
        fragmentDataBinding.article1 = newsList[0]
        fragmentDataBinding.article2 = newsList[0]
        fragmentDataBinding.article3 = newsList[0]
        fragmentDataBinding.article4 = newsList[0]
    }

    companion object {
        fun newInstance(): TallDarkArticleFragment {
            return TallDarkArticleFragment()
        }
    }
}