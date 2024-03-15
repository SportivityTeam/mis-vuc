package ru.sportivityteam.vucmirea.assistant.lesson.ui.entity

import ru.sportivityteam.vucmirea.assistant.lesson.domain.entity.LessonDomain

data class LessonPresentation(
    override val id: String,
    override val audience: String,
    override val lesson: String,
    override val employee: String,
    override val lessonTime: String
) : LessonDomain

fun LessonDomain.toPresentation(): LessonPresentation = LessonPresentation(
    id = id,
    audience = audience,
    lesson = lesson,
    employee = employee,
    lessonTime = lessonTime,
)