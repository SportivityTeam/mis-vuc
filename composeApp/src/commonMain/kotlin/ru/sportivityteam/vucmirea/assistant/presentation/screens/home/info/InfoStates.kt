package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info

data class InfoViewState(
    val isLoading: Boolean = false,

)

sealed class InfoViewAction {
    data object NavigateToSettings : InfoViewAction()
    data class NavigateToLesson(val lessonId: String) : InfoViewAction()
}

sealed class InfoViewEvent {
    data class OpenLesson(val lessonId: String) : InfoViewEvent()
}