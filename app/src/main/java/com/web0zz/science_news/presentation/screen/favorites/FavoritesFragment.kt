package com.web0zz.science_news.presentation.screen.favorites

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentFavoritesBinding
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.MainActivity
import com.web0zz.science_news.presentation.adapter.favorite.FavoritesRecyclerAdapter
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
@AndroidEntryPoint
class FavoritesFragment :
    BaseMainFragment<FragmentFavoritesBinding, FavoritesViewModel>(FragmentFavoritesBinding::inflate) {
    private val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private var favoritesRecyclerAdapter: FavoritesRecyclerAdapter? = null
    private var favoritesRecyclerView: RecyclerView? = null

    override val viewModel: FavoritesViewModel by viewModels()
    override val progressBar: View = (requireActivity() as MainActivity).progressBar

    override fun initCreate() {
        viewModel.getFavoriteArticles()
        super.initCreate()
    }

    override fun initUi() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.favoritesUiState.collect { uiState ->
                    setProgressStatus(uiState.isLoading)

                    uiState.errorMessage?.let {
                        showErrorDialog("Error on Favorites", it)
                    }

                    handleArticleList(uiState.favoriteArticles)
                }
            }
        }
    }

    private fun handleArticleList(articleData: List<Article>) {
        initRecyclerViewItems(articleData)
    }

    private fun initRecyclerViewItems(articleData: List<Article>) {
        if (favoritesRecyclerView == null || favoritesRecyclerAdapter == null) {
            initRecyclerView()
        } else {
            favoritesRecyclerAdapter!!.differ.submitList(articleData)
        }
    }

    private fun initRecyclerView() {
        with(fragmentDataBinding.articleFavoritesRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = favoritesRecyclerAdapter ?: FavoritesRecyclerAdapter(toArticleDetail()).also {
                favoritesRecyclerAdapter = it
            }

            favoritesRecyclerView = favoritesRecyclerView ?: this
        }
    }

    private fun toArticleDetail() = object : ClickActionTypes.OnClickDetail {
        override fun action(data: Int) {
            val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
    }
}