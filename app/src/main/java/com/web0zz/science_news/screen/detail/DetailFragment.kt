package com.web0zz.science_news.screen.detail

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.detail.DetailBodyRecyclerAdapter
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.data.dummySource.DummyData.defaultDetailBody
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.FragmentDetailBinding
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class DetailFragment : BaseMainFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    override val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }
    override val safeArgs: DetailFragmentArgs by navArgs()
    private lateinit var selectedArticle: Article

    override fun getArgumentsToVariable() {
        selectedArticle = DummyDataSource().articleList.find { it.id == safeArgs.articleId }!!
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle
        fragmentDataBinding.onClickBack = onBack()

        // Recyclerview helps us to add new content types like video, image slider, etc.
        // For showcase it is using same hierarchy in all detail screens.
        fragmentDataBinding.bodyRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = DetailBodyRecyclerAdapter(defaultDetailBody(selectedArticle))
            setHasFixedSize(true)
        }
    }

    private fun onBack() = object : FragmentUtil.OnClickBackOnDetail {
        override fun action(data: Nothing?) {
            navController?.popBackStack()
        }
    }
}