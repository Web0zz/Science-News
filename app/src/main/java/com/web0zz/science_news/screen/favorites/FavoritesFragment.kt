package com.web0zz.science_news.screen.favorites

import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentFavoritesBinding

class FavoritesFragment :
    BaseMainFragment<FragmentFavoritesBinding>(FragmentFavoritesBinding::inflate) {
    override val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }
    override val safeArgs: NavArgs? = null

    /*
    override fun initUi() = initRecyclerViewItems()

    // TODO will come from ViewModel that holds article contents
    // TODO Filter isSaved == true
    private val articleData = listOf<ArticleItem>()

    private fun initRecyclerViewItems() {
        fragmentDataBinding.articleFavoritesRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FavoritesRecyclerAdapter(articleData, toArticleDetail())
        }
    }

    private fun toArticleDetail() = object : FragmentUtil.OnClickDetail {
        override fun action(data: Int) {
            val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(data)
            navController?.navigate(action)
        }
    }*/
}