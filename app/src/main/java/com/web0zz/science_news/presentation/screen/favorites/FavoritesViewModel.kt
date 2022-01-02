package com.web0zz.science_news.presentation.screen.favorites

import androidx.lifecycle.viewModelScope
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.Article
import com.web0zz.science_news.domain.usecase.UseCase
import com.web0zz.science_news.domain.usecase.news.GetFavoriteArticlesUseCase
import com.web0zz.science_news.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase
) : BaseViewModel() {
    private val _favoritesUiState = MutableStateFlow(FavoritesUiState(isLoading = true))
    val favoritesUiState: StateFlow<FavoritesUiState> = _favoritesUiState

    fun getFavoriteArticles() {
        job?.cancel()

        getFavoriteArticlesUseCase(UseCase.None(), viewModelScope) {
            job = viewModelScope.launch {
                it.onStart { setLoading() }
                    .collect { result ->
                        result.mapBoth(::handleArticleList, ::handleFailure)
                    }
            }
        }
    }

    private fun setLoading() {
        _favoritesUiState.update { currentUiState ->
            currentUiState.copy(isLoading = true)
        }
    }

    private fun handleArticleList(data: List<Article>) {
        _favoritesUiState.update { currentUiState ->
            currentUiState.copy(favoriteArticles = data)
        }
    }

    private fun handleFailure(failure: Failure) {
        _favoritesUiState.update { currentUiState ->
            currentUiState.copy(errorMessage = failure.message)
        }
    }
}