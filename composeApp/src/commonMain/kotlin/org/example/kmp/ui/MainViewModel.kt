package org.example.kmp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.kmp.networking.DogRepository

class MainViewModel(
    private val dogRepository: DogRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> get() = _uiState

    init {
        getDogImage()
    }

    fun getDogImage() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                isError = false
            )
            val result = dogRepository.getDogImage()
            if(result.isSuccess) {
                val url = result.getOrNull()?.message ?: ""
                _uiState.value = _uiState.value.copy(dogImageUrl = url)
            } else {
                println(result.exceptionOrNull())
                _uiState.value = _uiState.value.copy(isError = true)
            }
            _uiState.value = _uiState.value.copy(isLoading = false)
        }
    }
}