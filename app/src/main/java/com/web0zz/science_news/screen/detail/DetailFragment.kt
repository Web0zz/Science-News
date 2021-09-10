package com.web0zz.science_news.screen.detail

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.FragmentDetailScreenBinding
import com.web0zz.science_news.screen.detail.handler.ActionHandler.moveBack
import kotlin.properties.Delegates

private const val NEWS_ID = "newsId"

class DetailFragment : BaseFragment<FragmentDetailScreenBinding>() {
    override fun getLayoutId() = R.layout.fragment_detail_screen

    private var selectedNewsId by Delegates.notNull<Int>()

    override fun Bundle.getArgumentsToVariable() {
        selectedNewsId = this.getInt(NEWS_ID)
    }

    override fun initUi() {
        val mainActivity = (activity as MainActivity)

        fragmentDataBinding.article = getSelectedArticle(selectedNewsId)
        fragmentDataBinding.activity = mainActivity

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    moveBack(mainActivity)
                }
            })
    }

    companion object {
        fun newInstance(newsID: Int): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(NEWS_ID, newsID)
                }
            }
    }

    private fun getSelectedArticle(id: Int) = newsList[id]
}