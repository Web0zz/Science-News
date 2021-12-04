package com.web0zz.science_news.screen.home

import androidx.navigation.NavArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.home.body.BodyRecyclerAdapter
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class HomeFragment : BaseMainFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }
    override val safeArgs: NavArgs? = null

    private val articleData = DummyDataSource().newsList

    override fun initUi() = initRecyclerviewItems()

    private fun initRecyclerviewItems() {
        fragmentDataBinding.articleItemsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = BodyRecyclerAdapter(articleData, toDetailArticle(), toOverviewArticle())
        }
    }

    private fun toDetailArticle() = object :
        FragmentUtil.OnClickDetail {
        override fun action(data: Int) {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
    }

    private fun toOverviewArticle() =
        object : FragmentUtil.OnClickOverview {
            override fun action(data: Int) {
                val action = HomeFragmentDirections.actionHomeFragmentToOverviewFragment(data)
                navController?.navigate(action)
            }
        }
}