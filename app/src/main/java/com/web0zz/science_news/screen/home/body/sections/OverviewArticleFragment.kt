package com.web0zz.science_news.screen.home.body.sections


import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.dummySource.DummyData.overviewList
import com.web0zz.science_news.data.model.ShortVideo
import com.web0zz.science_news.data.model.view.sections.ShortArticle
import com.web0zz.science_news.data.model.view.sections.TallArticle
import com.web0zz.science_news.databinding.ViewOverviewArticleBinding
import com.web0zz.science_news.util.FragmentUtil

class OverviewArticleFragment :
    BaseFragment<ViewOverviewArticleBinding>(ViewOverviewArticleBinding::inflate) {
    override fun initUi() {
        overviewList.let {
            it.forEach { overview ->
                overview.videos = listOf(
                    // TODO will declare values outside
                    ShortVideo(0, (DummyData.newsList[0] as TallArticle).article),
                    ShortVideo(1, (DummyData.newsList[1] as ShortArticle).article),
                    ShortVideo(2, (DummyData.newsList[2] as ShortArticle).article),
                    ShortVideo(3, (DummyData.newsList[3] as ShortArticle).article),
                    ShortVideo(4, (DummyData.newsList[4] as ShortArticle).article),
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
