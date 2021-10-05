package com.web0zz.science_news.screen.home.body

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
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
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            animation =
                AnimationUtils.loadAnimation(context, R.anim.recyclerview_article_section_anim)
            adapter = BodyRecyclerAdapter(articleData,
                object : FragmentUtil.OnClickDetail {
                    override val mainActivity: MainActivity
                        get() = requireActivity() as MainActivity
                }
            )
        }
    }

    companion object {
        fun newInstance(): HomeBodyFragment =
            HomeBodyFragment()
    }
}