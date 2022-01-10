package com.web0zz.science_news.presentation.screen.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.adapter.home.body.NewsRecyclerAdapter
import com.web0zz.science_news.presentation.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.News
import com.web0zz.science_news.domain.model.view.sections.ArticleItem
import com.web0zz.science_news.presentation.MainActivity
import com.web0zz.science_news.presentation.adapter.favorite.FavoritesRecyclerAdapter
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
@AndroidEntryPoint
class HomeFragment :
    BaseMainFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {
    private val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private var newsRecyclerAdapter: NewsRecyclerAdapter? = null
    private var newsRecyclerView: RecyclerView? = null

    override val viewModel: HomeViewModel by viewModels()
    override val progressBar: View = (requireActivity() as MainActivity).progressBar

    override fun initCreate() {
        viewModel.getAllArticles()
        super.initCreate()
    }

    override fun initUi() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeUiState.collect { uiState ->
                    setProgressStatus(uiState.isLoading)

                    uiState.errorMessage?.let {
                        showErrorDialog("Error on Home", it)
                    }

                    uiState.homeArticles?.let { news -> handleArticleList(news) }
                }
            }
        }
    }

    private fun handleArticleList(newsData: News) {
        initRecyclerViewItems(newsData.articles)
    }

    private fun initRecyclerViewItems(articleData: List<ArticleItem>) {
        if (newsRecyclerView == null || newsRecyclerAdapter == null) {
            initRecyclerView()
        } else {
            newsRecyclerAdapter!!.differ.submitList(articleData)
        }
    }

    private fun initRecyclerView() {
        with(fragmentDataBinding.articleItemsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = newsRecyclerAdapter ?: NewsRecyclerAdapter(
                toDetailArticle(),
                toOverviewArticle()
            ).also {
                newsRecyclerAdapter = it
            }

            newsRecyclerView = newsRecyclerView ?: this
        }
    }

    private fun toDetailArticle() = object :
        ClickActionTypes.OnClickDetail {
        override fun action(data: Int) {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
    }

    private fun toOverviewArticle() =
        object : ClickActionTypes.OnClickOverview {
            override fun action(data: Int) {
                val action = HomeFragmentDirections.actionHomeFragmentToOverviewFragment(data)
                navController?.navigate(action)
            }
        }
}