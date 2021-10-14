package com.web0zz.science_news.screen.detail

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.adapter.detail.DetailBodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData.defaultDetailBody
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.detail.ContentImage
import com.web0zz.science_news.data.model.view.detail.NormalBody
import com.web0zz.science_news.data.model.view.detail.ShortDescription
import com.web0zz.science_news.databinding.FragmentDetailBinding
import com.web0zz.science_news.util.FragmentUtil

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private lateinit var selectedArticle: Article

    override fun Bundle.getArgumentsToVariable() {
        selectedArticle = this.getParcelable(ARTICLE)!!
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle
        fragmentDataBinding.onClickBack = onBack()

        fragmentDataBinding.bodyRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = DetailBodyRecyclerAdapter(defaultDetailBody(selectedArticle))
        }
    }

    private fun onBack() = object : FragmentUtil.OnClickBackOnDetail {
        override fun action(data: Nothing?) = parentFragmentManager.popBackStack()
    }

    override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = onBack().action(null)
        }

    companion object {
        private const val ARTICLE = "article"

        fun newInstance(article: Article): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARTICLE, article)
                }
            }
    }
}