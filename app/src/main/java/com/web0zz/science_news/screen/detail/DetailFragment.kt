package com.web0zz.science_news.screen.detail

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.adapter.detail.DetailBodyRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.detail.ContentImage
import com.web0zz.science_news.data.model.view.detail.NormalBody
import com.web0zz.science_news.data.model.view.detail.ShortDescription
import com.web0zz.science_news.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private lateinit var selectedArticle: Article

    override fun Bundle.getArgumentsToVariable() {
        selectedArticle = this.getParcelable(ARTICLE)!!
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle
        fragmentDataBinding.fragInterface = this

        fragmentDataBinding.bodyRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = DetailBodyRecyclerAdapter(
                listOf(
                    ShortDescription(selectedArticle.shortBody),
                    NormalBody(selectedArticle.bodyText[0]),
                    ContentImage(selectedArticle.contentImage),
                    NormalBody(selectedArticle.bodyText[1]),
                )
            )
            // TODO will find a way to get order of items
        }

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    moveBack()
                }
            })
    }

    fun moveBack() {
        val mainActivity = (requireActivity() as MainActivity)

        mainActivity.initDetail(true)
        mainActivity.initHome(false)
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