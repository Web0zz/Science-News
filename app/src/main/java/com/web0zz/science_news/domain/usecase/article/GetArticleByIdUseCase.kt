package com.web0zz.science_news.domain.usecase.article

import com.github.michaelbull.result.Result
import com.web0zz.science_news.di.MainDispatcher
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.repository.ArticleRepository
import com.web0zz.science_news.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticleByIdUseCase @Inject constructor(
    private val articleRepository: ArticleRepository,
    @MainDispatcher mainDispatcher: CoroutineDispatcher
) : UseCase<Article, Failure, Int>(mainDispatcher) {
    override suspend fun run(params: Int): Flow<Result<Article, Failure>> =
        articleRepository.getArticleById(params)
}