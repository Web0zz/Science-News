package com.web0zz.science_news.screen.favorites

import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.adapter.favorites.FavoritesRecyclerAdapter
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.model.Article
import com.web0zz.science_news.data.model.view.sections.ArticleItem
import com.web0zz.science_news.databinding.FragmentFavoritesBinding
import com.web0zz.science_news.util.FragmentUtil
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding>(FragmentFavoritesBinding::inflate) {
    override fun initUi() = initRecyclerViewItems()

    // TODO will come from ViewModel that holds article contents
    // TODO Filter isSaved == true
    private val articleData = listOf<ArticleItem>()

    private fun initRecyclerViewItems() {
        fragmentDataBinding.articleFavoritesRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FavoritesRecyclerAdapter(articleData,
                object : FragmentUtil.OnClickDetail {
                    override fun action(data: Article) {
                        toArticleDetail(data)
                    }
                }
            )
        }
    }

    private fun toArticleDetail(article: Article) {
        val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(article)
        getFragmentNavController(R.id.nav_host_fragmentContainerView)?.navigate(action)
    }
}