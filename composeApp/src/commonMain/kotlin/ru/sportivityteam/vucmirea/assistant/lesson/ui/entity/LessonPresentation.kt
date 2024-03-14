package ru.sportivityteam.vucmirea.assistant.lesson.ui.entity

import ru.sportivityteam.vucmirea.assistant.domain.auth.entity.LessonDomain

data class LessonPresentation(
    override val id: String,
    override val audience: String,
    override val lesson: String,
    override val employee: String,
    override val lessonTime: String
) : LessonDomain