package com.web0zz.science_news.screen.detail

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.DummyData.newsList
import com.web0zz.science_news.databinding.FragmentDetailBinding
import kotlin.properties.Delegates

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private var selectedNewsId by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        selectedNewsId = this.getInt(NEWS_ID)
    }

    override fun initUi() {
        fragmentDataBinding.article = getSelectedArticle(selectedNewsId)
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
        private const val NEWS_ID = "newsId"

        fun newInstance(newsID: Int): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(NEWS_ID, newsID)
                }
            }
    }

    private fun getSelectedArticle(id: Int) = newsList[id]
}