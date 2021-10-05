package com.web0zz.science_news.screen.detail

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData.newsList
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.databinding.FragmentDetailBinding
import kotlin.properties.Delegates

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private lateinit var selectedArticle : Article

    override fun Bundle.getArgumentsToVariable() {
        selectedArticle = this.getParcelable(ARTICLE)!!
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle
        fragmentDataBinding.fragInterface = this

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