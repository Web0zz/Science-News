package com.web0zz.science_news.domain.usecase.news

import com.github.michaelbull.result.Result
import com.web0zz.science_news.di.MainDispatcher
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.model.News
import com.web0zz.science_news.domain.repository.ArticleRepository
import com.web0zz.science_news.domain.repository.NewsRepository
import com.web0zz.science_news.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    @MainDispatcher mainDispatcher: CoroutineDispatcher
) : UseCase<News, Failure, UseCase.None>(mainDispatcher) {
    override suspend fun run(params: None): Flow<Result<News, Failure>> =
        newsRepository.getNews()
}