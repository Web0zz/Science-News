package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.dummyData.overviewList
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding

class OverviewArticleFragment : BaseFragment<ViewOverviewArticleBinding>() {
    override fun getLayoutId() = R.layout.view_overview_article

    override fun initUi() {
        overviewList.let {
            fragmentDataBinding.overviewList = overviewList
        }
    }

    companion object {
        fun newInstance(): OverviewArticleFragment {
            return OverviewArticleFragment()
        }
    }
}
