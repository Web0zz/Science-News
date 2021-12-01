package com.web0zz.science_news.screen.detail

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.detail.DetailBodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData.defaultDetailBody
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.FragmentDetailBinding
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private val safeArgs: DetailFragmentArgs by navArgs()
    private lateinit var selectedArticle: Article

    override fun getArgumentsToVariable() {
        selectedArticle = safeArgs.article
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle
        fragmentDataBinding.onClickBack = onBack()

        fragmentDataBinding.bodyRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = DetailBodyRecyclerAdapter(defaultDetailBody(selectedArticle))
            setHasFixedSize(true)
        }
    }

    private fun onBack() = object : FragmentUtil.OnClickBackOnDetail {
        override fun action(data: Nothing?) {
            getFragmentNavController(R.id.nav_host_fragmentContainerView)?.popBackStack()
        }
    }

    /*companion object {
        private const val ARTICLE = "article"

        *//*fun newInstance(article: Article): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARTICLE, article)
                }
            }*//*
    }*/
}