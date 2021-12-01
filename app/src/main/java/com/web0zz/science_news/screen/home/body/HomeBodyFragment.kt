package com.web0zz.science_news.screen.home.body

import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.home.body.BodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ViewHomeBodyBinding
import com.web0zz.science_news.screen.home.HomeFragmentDirections
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class HomeBodyFragment : BaseFragment<ViewHomeBodyBinding>(ViewHomeBodyBinding::inflate) {
    override fun initUi() = initRecyclerviewItems()

    private val articleData = DummyData.newsList

    private fun initRecyclerviewItems() {
        fragmentDataBinding.articleItemsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = BodyRecyclerAdapter(articleData,
                object : FragmentUtil.OnClickDetail {
                    override fun action(data: Article) {
                        toDetailArticle(data)
                    }
                },
                object : FragmentUtil.OnClickOverview {
                    override fun action(data: Int) {
                        toOverviewArticle(data)
                    }
                }
            )
        }
    }

    private fun toDetailArticle(article: Article) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(article)
        getFragmentNavController(R.id.nav_host_fragmentContainerView)?.navigate(action)
    }

    private fun toOverviewArticle(overviewId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToOverviewFragment(overviewId)
        getFragmentNavController(R.id.nav_host_fragmentContainerView)?.navigate(action)
    }

    companion object {
        fun newInstance(): HomeBodyFragment =
            HomeBodyFragment()
    }
}