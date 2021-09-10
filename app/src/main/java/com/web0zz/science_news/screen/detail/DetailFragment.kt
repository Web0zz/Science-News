package com.web0zz.science_news.screen.detail

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.newsList
import com.web0zz.science_news.databinding.FragmentDetailScreenBinding
import kotlin.properties.Delegates

private const val NEWS_ID = "newsId"

class DetailFragment : BaseFragment<FragmentDetailScreenBinding>() {
    override fun getLayoutId() = R.layout.fragment_detail_screen

    private var selectedNewsId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

        arguments?.let {
            selectedNewsId = it.getInt(NEWS_ID)
        }
    }

    override fun initUi() {
        fragmentDataBinding.article = getSelectedArticle(selectedNewsId)

        fragmentDataBinding.backButton.setOnClickListener { moveBack() }

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    moveBack()
                }
            })
    }

    private fun moveBack() {
        val mainActivity = (activity as MainActivity)

        mainActivity.initDetail(true)
        mainActivity.initHome(false)
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