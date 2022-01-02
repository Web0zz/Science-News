package com.web0zz.science_news.domain.repository

import com.github.michaelbull.result.Result
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<Result<News, Failure>>
}