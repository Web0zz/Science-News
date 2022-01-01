package com.web0zz.science_news.domain.repository

import com.github.michaelbull.result.Result
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getAllArticle(): Flow<Result<List<Article>, Failure>>
    suspend fun getFavoriteArticles(): Flow<Result<List<Article>, Failure>>
    suspend fun getArticleById(articleId: Int): Flow<Result<Article, Failure>>
}