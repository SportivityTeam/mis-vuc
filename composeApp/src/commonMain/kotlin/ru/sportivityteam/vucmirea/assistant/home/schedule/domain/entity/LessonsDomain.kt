package ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity

import ru.sportivityteam.vucmirea.assistant.lesson.domain.entity.LessonDomain

interface LessonsDomain {
    val date: String
    val lessonsList: List<LessonDomain>
}