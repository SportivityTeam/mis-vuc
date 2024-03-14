package ru.sportivityteam.vucmirea.assistant.lesson.data.entity

import ru.sportivityteam.vucmirea.assistant.lesson.domain.entity.LessonDomain

data class LessonData(
    override val id: String,
    override val audience: String,
    override val lesson: String,
    override val employee: String,
    override val lessonTime: String
) : LessonDomain