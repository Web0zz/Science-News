package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.ViewTallDarkArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.SectionHandler

class TallDarkArticleFragment : BaseFragment<ViewTallDarkArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_dark_article

    override fun initUi() {
        fragmentDataBinding.sectionHandler1 =
            SectionHandler(newsList[0], (activity as MainActivity))
        fragmentDataBinding.sectionHandler2 =
            SectionHandler(newsList[0], (activity as MainActivity))
        fragmentDataBinding.sectionHandler3 =
            SectionHandler(newsList[0], (activity as MainActivity))
        fragmentDataBinding.sectionHandler4 =
            SectionHandler(newsList[0], (activity as MainActivity))
    }

    companion object {
        fun newInstance(): TallDarkArticleFragment {
            return TallDarkArticleFragment()
        }
    }
}