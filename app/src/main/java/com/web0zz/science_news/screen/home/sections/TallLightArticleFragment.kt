package com.web0zz.science_news.screen.home.sections


import android.os.Bundle
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.dummySource.dummyData.newsList
import com.web0zz.science_news.databinding.ViewTallLightArticleBinding


class TallLightArticleFragment : BaseFragment<ViewTallLightArticleBinding>() {
    override fun getLayoutId() = R.layout.view_tall_light_article

    private lateinit var articles: List<HashMap<String, Int>>

    override fun Bundle.getArgumentsToVariable() {
        articles = listOf(
            hashMapOf(Pair("articleId1", this.getInt(ARTICLE_ID_1))),
            hashMapOf(Pair("articleId2", this.getInt(ARTICLE_ID_1))),
            hashMapOf(Pair("articleId3", this.getInt(ARTICLE_ID_1))),
            hashMapOf(Pair("articleId4", this.getInt(ARTICLE_ID_1)))
        )
    }

    override fun initUi() {
        fragmentDataBinding.articleList = newsList.subList(articles[0]["articleId1"]!!, articles[3]["articleId1"]!! + 1)
    }

    companion object {
        private const val ARTICLE_ID_1 = "articleId1"
        private const val ARTICLE_ID_2 = "articleId2"
        private const val ARTICLE_ID_3 = "articleId3"
        private const val ARTICLE_ID_4 = "articleId4"

        fun newInstance(
            articleId1: Int,
            articleId2: Int,
            articleId3: Int,
            articleId4: Int,
        ): TallLightArticleFragment {
            return TallLightArticleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARTICLE_ID_1, articleId1)
                    putInt(ARTICLE_ID_2, articleId2)
                    putInt(ARTICLE_ID_3, articleId3)
                    putInt(ARTICLE_ID_4, articleId4)
                }
            }
        }
    }
}