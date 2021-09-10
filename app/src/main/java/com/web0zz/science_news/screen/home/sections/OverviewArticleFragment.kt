package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding
import com.web0zz.science_news.screen.home.sections.handler.OverviewHandler

class OverviewArticleFragment : BaseFragment<ViewOverviewArticleBinding>() {
    override fun getLayoutId() = R.layout.view_overview_article

    override fun initUi() {
        fragmentDataBinding.overview = OverviewHandler
    }

    companion object {
        fun newInstance(): OverviewArticleFragment {
            return OverviewArticleFragment()
        }
    }
}
