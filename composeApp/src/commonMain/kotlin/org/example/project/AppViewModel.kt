package org.example.project

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel() : ViewModel() {
    private val _countStateFlow = MutableStateFlow(1)
    val countStateFlow get() = _countStateFlow.asStateFlow()

    fun setCount(count: Int) {
        _countStateFlow.value = count
    }
}