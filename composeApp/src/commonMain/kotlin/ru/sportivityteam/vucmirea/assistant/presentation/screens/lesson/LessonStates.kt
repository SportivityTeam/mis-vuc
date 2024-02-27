package ru.sportivityteam.vucmirea.assistant.presentation.screens.lesson

data class LessonViewState(
    val loading: Boolean = false
)

sealed class LessonViewAction {}

sealed class LessonViewEvent {}