package com.web0zz.science_news.screen.home.body

import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.adapter.home.body.BodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.ViewHomeBodyBinding
import com.web0zz.science_news.util.FragmentUtil

class HomeBodyFragment : BaseFragment<ViewHomeBodyBinding>(ViewHomeBodyBinding::inflate) {
    override fun initUi() = initRecyclerviewItems()

    private val articleData = DummyData.newsList

    private fun initRecyclerviewItems() {
        val mainActivity = (requireActivity() as MainActivity)

        fragmentDataBinding.articleItemsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = BodyRecyclerAdapter(articleData,
                object : FragmentUtil.OnClickDetail {
                    override fun action(data: Article) {
                        mainActivity.navigation.initDetail(data)
                    }
                },
                object : FragmentUtil.OnClickOverview {
                    override fun action(data: Int) {
                        mainActivity.navigation.initOverview(data)
                    }
                }
            )
        }
    }

    companion object {
        fun newInstance(): HomeBodyFragment =
            HomeBodyFragment()
    }
}