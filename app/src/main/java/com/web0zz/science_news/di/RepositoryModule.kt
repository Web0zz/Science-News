package com.web0zz.science_news.di

import com.web0zz.science_news.data.repository.ArticleRepositoryImpl
import com.web0zz.science_news.data.repository.NewsRepositoryImpl
import com.web0zz.science_news.domain.repository.ArticleRepository
import com.web0zz.science_news.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository

    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}