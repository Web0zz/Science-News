package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.ViewShortArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.SectionHandler

class ShortArticleFragment : BaseFragment<ViewShortArticleBinding>() {
    override fun getLayoutId() = R.layout.view_short_article

    override fun initUi() {
        fragmentDataBinding.sectionHandler = SectionHandler(newsList[0], (activity as MainActivity))
    }

    companion object {
        fun newInstance(): ShortArticleFragment {
            return ShortArticleFragment()
        }
    }
}