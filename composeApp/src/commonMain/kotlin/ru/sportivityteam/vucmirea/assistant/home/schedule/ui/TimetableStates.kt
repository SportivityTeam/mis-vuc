package ru.sportivityteam.vucmirea.assistant.home.schedule.ui

import ru.sportivityteam.vucmirea.assistant.lesson.ui.entity.LessonPresentation

data class TimetableViewState(
    val isLoading: Boolean = false,
    val day: String = "Пятница",
    val date: String = "14 октября",
    val lessons: List<LessonPresentation> = listOf(
        LessonPresentation(
            "2323",
            audience = "Ауд. 101",
            lesson = "ВСП",
            employee = "Ренкавик В.А.",
            lessonTime = "09:00-10:30"
        ),
        LessonPresentation(
            "2323",
            audience = "Ауд. 101",
            lesson = "ВСП",
            employee = "Ренкавик В.А.",
            lessonTime = "10:40-12:10"
        ),
        LessonPresentation(
            "2323",
            audience = "Ауд. 101",
            lesson = "ВСП",
            employee = "Ренкавик В.А.",
            lessonTime = "13:00-14:30"
        ),
        LessonPresentation(
            "2323",
            audience = "Ауд. 101",
            lesson = "ВСП",
            employee = "Ренкавик В.А.",
            lessonTime = "14:40-16:10"
        ),
    )
)

sealed class TimetableViewAction {
    data class NavigateToLesson(val lessonId: String) : TimetableViewAction()
}

sealed class TimetableViewEvent {
    data class OpenLesson(val lessonId: String) : TimetableViewEvent()
    data object Clear : TimetableViewEvent()
}