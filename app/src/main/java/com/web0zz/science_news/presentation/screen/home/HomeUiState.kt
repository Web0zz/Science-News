package com.web0zz.science_news.presentation.screen.home

import com.web0zz.science_news.domain.model.News

data class HomeUiState(
    val homeArticles: News? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)