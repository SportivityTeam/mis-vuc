package ru.sportivityteam.vucmirea.assistant.core.uikit.extensions

import kotlinx.coroutines.flow.MutableStateFlow

suspend fun MutableStateFlow<Boolean>.setFilled(input: String) {
    if (input.isNotEmpty()) emit(value = true)
    else emit(value = false)
}