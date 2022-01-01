package com.web0zz.science_news.presentation.screen.favorites

import com.web0zz.science_news.domain.model.Article

data class FavoritesUiState(
    val favoriteArticles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)