package com.web0zz.science_news.presentation.screen.detail

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.adapter.detail.DetailBodyRecyclerAdapter
import com.web0zz.science_news.presentation.base.BaseMainFragment
import com.web0zz.science_news.data.dummySource.DummyData.defaultDetailBody
import com.web0zz.science_news.data.dummySource.DummyDataSource
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.databinding.FragmentDetailBinding
import com.web0zz.science_news.util.shareArticleLink

class DetailFragment : BaseMainFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    override val navController by lazy {
        activity?.let {
            return@let Navigation.findNavController(it, R.id.nav_host_fragmentContainerView)
        }
    }
    override val safeArgs: DetailFragmentArgs by navArgs()
    private lateinit var selectedArticle: Article

    override fun initCreate() {
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.setGroupVisible(R.id.global_menu_group, false)
        menu.setGroupVisible(R.id.detail_menu_group, true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share_menu -> {
                context?.shareArticleLink(selectedArticle.shareLink)
                true
            }
            R.id.save_menu -> {
                when (selectedArticle.isSaved) {
                    true -> {
                        selectedArticle.isSaved = false
                        item.setIcon(R.drawable.ic_unsaved)
                        Toast.makeText(context, "Article Unsaved", Toast.LENGTH_SHORT).show()
                    }
                    false -> {
                        selectedArticle.isSaved = true
                        item.setIcon(R.drawable.ic_saved)
                        Toast.makeText(context, "Article Saved", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getArgumentsToVariable() {
        selectedArticle = DummyDataSource().articleList.find { it.id == safeArgs.articleId }!!
    }

    override fun initUi() {
        fragmentDataBinding.article = selectedArticle

        // Recyclerview helps us to add new content types like video, image slider, etc.
        // For showcase it is using same hierarchy in all detail screen.
        fragmentDataBinding.bodyRecyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = DetailBodyRecyclerAdapter(defaultDetailBody(selectedArticle))
            setHasFixedSize(true)
        }
    }
}