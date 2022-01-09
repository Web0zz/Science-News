package com.web0zz.science_news.presentation.screen.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.adapter.home.body.NewsRecyclerAdapter
import com.web0zz.science_news.presentation.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.presentation.MainActivity
import com.web0zz.science_news.presentation.extras.ClickActionTypes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseMainFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {
    override val viewModel: HomeViewModel by viewModels()
    override val progressBar: View = (requireActivity() as MainActivity).progressBar

    private val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }

    private var newsRecyclerAdapter: NewsRecyclerAdapter? = null

    override fun initUi() = initRecyclerviewItems()

    private fun initRecyclerviewItems() {
        fragmentDataBinding.articleItemsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            /*adapter = NewsRecyclerAdapter(articleData, toDetailArticle(), toOverviewArticle())*/
            setHasFixedSize(false)
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