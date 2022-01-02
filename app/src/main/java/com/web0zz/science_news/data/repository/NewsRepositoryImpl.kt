package com.web0zz.science_news.data.repository

import com.github.michaelbull.result.Result
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.News
import com.web0zz.science_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl : NewsRepository {
    override suspend fun getNews(): Flow<Result<News, Failure>> {
        TODO("Not yet implemented")
    }
}