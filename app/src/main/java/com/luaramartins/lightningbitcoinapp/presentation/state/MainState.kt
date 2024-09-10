package com.luaramartins.lightningbitcoinapp.presentation.state

data class MainState<T>(
    val isLoading: Boolean = false,
    val value: List<T> = emptyList(),
    val error: String = ""
)