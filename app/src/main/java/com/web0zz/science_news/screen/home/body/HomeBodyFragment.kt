package com.web0zz.science_news.screen.home.body

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.adapter.home.body.BodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData
import com.web0zz.science_news.databinding.ViewHomeBodyBinding
import com.web0zz.science_news.util.FragmentUtil

class HomeBodyFragment : BaseFragment<ViewHomeBodyBinding>(ViewHomeBodyBinding::inflate) {
    override fun initUi() = initRecyclerviewItems()

    private val articleData = DummyData.newsList

    private fun initRecyclerviewItems() {
        fragmentDataBinding.articleItemsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = BodyRecyclerAdapter(articleData,
                object : FragmentUtil.OnClickDetail {
                    override val mainActivity: MainActivity
                        get() = requireActivity() as MainActivity
                }
            ).apply {
                stateRestorationPolicy =
                    RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
            }
        }
    }

    companion object {
        fun newInstance(): HomeBodyFragment =
            HomeBodyFragment()
    }
}