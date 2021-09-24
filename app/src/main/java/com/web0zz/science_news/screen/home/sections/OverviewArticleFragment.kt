package com.web0zz.science_news.screen.home.sections


import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.dummySource.DummyData.overviewList
import com.web0zz.science_news.data.model.ShortVideo
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class OverviewArticleFragment : BaseFragment<ViewOverviewArticleBinding>() {
    override fun getLayoutId() = R.layout.view_overview_article

    override fun initUi() {
        overviewList.let {
            it.forEach { overview ->
                overview.videos = listOf(
                    // TODO will declare values outside
                    ShortVideo(0, DummyData.newsList[0]),
                    ShortVideo(1, DummyData.newsList[1]),
                    ShortVideo(2, DummyData.newsList[2]),
                    ShortVideo(3, DummyData.newsList[3]),
                    ShortVideo(4, DummyData.newsList[4]),
                )
            }
            fragmentDataBinding.overviewListData = it
            fragmentDataBinding.onClickOverview = object : FragmentUtil.OnClickOverview {
                override val mainActivity: MainActivity
                    get() = (requireActivity() as MainActivity)
            }
        }
    }

    companion object {
        fun newInstance(): OverviewArticleFragment {
            return OverviewArticleFragment()
        }
    }
}
