package org.example.kmp.ui

data class MainUiState(
    val dogImageUrl: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
