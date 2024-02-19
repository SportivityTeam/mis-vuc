package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee

data class HomeViewState(
    val isLoading: Boolean = false,
    val groupNumber: String = "",
    val date: String = "",
    val lessons: List<Unit> = listOf()
)

sealed class HomeViewAction {
    data object NavigateToSettings : HomeViewAction()
    data class NavigateToLesson(val lessonId: String) : HomeViewAction()
}

sealed class HomeViewEvent {
    data class OpenLesson(val lessonId: String) : HomeViewEvent()
}