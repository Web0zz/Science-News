package com.web0zz.science_news.screen.favorites

import androidx.navigation.NavArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.favorites.FavoritesRecyclerAdapter
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.sections.ArticleItem
import com.web0zz.science_news.databinding.FragmentFavoritesBinding
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class FavoritesFragment :
    BaseMainFragment<FragmentFavoritesBinding>(FragmentFavoritesBinding::inflate) {
    override val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }
    override val safeArgs: NavArgs? = null

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
    }
}