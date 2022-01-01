package com.web0zz.science_news.presentation.screen.favorites

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentFavoritesBinding
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.presentation.MainActivity
import com.web0zz.science_news.presentation.adapter.favorite.FavoritesRecyclerAdapter
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import com.web0zz.science_news.presentation.screen.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
@AndroidEntryPoint
class FavoritesFragment :
    BaseMainFragment<FragmentFavoritesBinding, FavoritesViewModel>(FragmentFavoritesBinding::inflate) {
    private val safeArgs: NavArgs? = null
    private val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private var favoritesRecyclerAdapter: FavoritesRecyclerAdapter? = null

    override val progressBar: View = (requireActivity() as MainActivity).progressBar
    override val viewModel: FavoritesViewModel by viewModels()

    override fun initUi() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.favoritesUiState.collect { uiState ->
                    setProgressStatus(uiState.isLoading)

                    uiState.errorMessage?.let {
                        showErrorDialog("Error on Favorites", it)
                    }

                    handleArticleList()
                }
            }
        }
    }

    private fun initRecyclerViewItems(articleData: List<Article>) {
        if (favoritesRecyclerAdapter == null) {
            fragmentDataBinding.articleFavoritesRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = FavoritesRecyclerAdapter(listOf(), toArticleDetail())
            }
        } else {
            favoritesRecyclerAdapter.submit
        }
    }

    private fun handleArticleList() {

    }

    private fun toArticleDetail() = object : ClickActionTypes.OnClickDetail {
        override fun action(data: Int) {
            val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
    }
}