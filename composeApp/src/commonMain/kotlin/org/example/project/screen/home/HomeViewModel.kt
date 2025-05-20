package org.example.project.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _homeUIStateFlow = MutableStateFlow(HomeUIState())
    val homeUIStateFlow get() = _homeUIStateFlow.asStateFlow()

    fun setCount(count: Int) {
        _homeUIStateFlow.value = _homeUIStateFlow.value.copy(count = count)
    }

    fun setNavigateToDetail(navigateToDetail: String) {
        _homeUIStateFlow.value = _homeUIStateFlow.value.copy(navigateToDetail = navigateToDetail)
    }

    fun resetNavigateToDetail() {
        _homeUIStateFlow.value = _homeUIStateFlow.value.copy(navigateToDetail = "")
    }
}