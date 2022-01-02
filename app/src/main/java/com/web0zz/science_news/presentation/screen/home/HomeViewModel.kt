package com.web0zz.science_news.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.mapBoth
import com.web0zz.science_news.domain.exception.Failure
import com.web0zz.science_news.domain.model.News
import com.web0zz.science_news.domain.usecase.UseCase
import com.web0zz.science_news.domain.usecase.news.GetNewsUseCase
import com.web0zz.science_news.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) :  BaseViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState(isLoading = true))
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    fun getAllArticles() {
        job?.cancel()

        getNewsUseCase(UseCase.None(), viewModelScope) {
            job = viewModelScope.launch {
                it.onStart { setLoading() }
                    .collect { result ->
                        result.mapBoth(::handleNews, ::handleFailure)
                    }
            }
        }
    }

    private fun setLoading() {
        _homeUiState.update { currentUiState ->
            currentUiState.copy(isLoading = true)
        }
    }

    private fun handleNews(data: News) {
        _homeUiState.update { currentUiState ->
            currentUiState.copy(homeArticles = data)
        }
    }

    private fun handleFailure(failure: Failure) {
        _homeUiState.update { currentUiState ->
            currentUiState.copy(errorMessage = failure.message)
        }
    }
}