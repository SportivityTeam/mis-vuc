package ru.sportivityteam.vucmirea.assistant.lesson.domain.entity

interface LessonDomain {
    val id: String
    val audience: String
    val lesson: String
    val employee: String
    val lessonTime: String
}