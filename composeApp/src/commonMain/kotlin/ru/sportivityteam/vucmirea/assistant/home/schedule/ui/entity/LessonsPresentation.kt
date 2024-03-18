package ru.sportivityteam.vucmirea.assistant.home.schedule.ui.entity

import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.LessonsDomain
import ru.sportivityteam.vucmirea.assistant.lesson.ui.entity.LessonPresentation
import ru.sportivityteam.vucmirea.assistant.lesson.ui.entity.toPresentation

data class LessonsPresentation(
    override val date: String = "",
    override val lessonsList: List<LessonPresentation> = listOf()
) : LessonsDomain

fun LessonsDomain.toPresentationModel() = LessonsPresentation(
    date = date,
    lessonsList = lessonsList.map {
        it.toPresentation()
    }
)