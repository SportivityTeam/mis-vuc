package ru.sportivityteam.vucmirea.assistant.lesson.ui

import ru.sportivityteam.vucmirea.assistant.lesson.ui.entity.LessonPresentation

data class LessonViewState(
    val loading: Boolean = false,
    val groupNumber: String = "551",
    val lesson: LessonPresentation = LessonPresentation(
        "2323",
        audience = "Ауд. 101",
        lesson = "ВСП",
        employee = "Ренкавик В.А.",
        lessonTime = "09:00-10:30"
    )
)

sealed class LessonViewAction {}

sealed class LessonViewEvent {}