package ru.sportivityteam.vucmirea.assistant.data.auth.entity

import ru.sportivityteam.vucmirea.assistant.domain.auth.entity.LessonDomain

data class LessonData(
    override val id: String,
    override val audience: String,
    override val lesson: String,
    override val employee: String,
    override val lessonTime: String
) : LessonDomain