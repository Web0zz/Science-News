package com.web0zz.science_news.data.repository

import com.github.michaelbull.result.Result
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticleRepositoryImpl : ArticleRepository {
    override suspend fun getAllArticle(): Flow<Result<List<Article>, Failure>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteArticles(): Flow<Result<List<Article>, Failure>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArticleById(articleId: Int): Flow<Result<Article, Failure>> {
        TODO("Not yet implemented")
    }
}