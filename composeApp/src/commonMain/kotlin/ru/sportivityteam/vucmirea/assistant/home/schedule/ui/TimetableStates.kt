package ru.sportivityteam.vucmirea.assistant.home.schedule.ui

import ru.sportivityteam.vucmirea.assistant.home.schedule.ui.entity.LessonsPresentation

data class TimetableViewState(
    val isLoading: Boolean = false,
    val day: String = "Пятница",
    val date: String = "14 октября",
    val lessons: LessonsPresentation = LessonsPresentation()
)

sealed class TimetableViewAction {
    data class NavigateToLesson(val lessonId: String) : TimetableViewAction()
}

sealed class TimetableViewEvent {
    data class OpenLesson(val lessonId: String) : TimetableViewEvent()
    data object Clear : TimetableViewEvent()
}