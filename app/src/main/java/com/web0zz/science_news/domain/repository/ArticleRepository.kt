package com.web0zz.science_news.domain.repository

import com.web0zz.science_news.domain.model.Article

interface ArticleRepository {
    suspend fun getAllArticle(): List<Article>
    suspend fun getArticleById(articleId: Int): Article
}