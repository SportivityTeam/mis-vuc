package ru.sportivityteam.vucmirea.assistant.home.schedule.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.LessonsDomain
import ru.sportivityteam.vucmirea.assistant.lesson.data.entity.LessonData

@Serializable
data class LessonsData(
    @SerialName("date")
    override val date: String = "",
    @SerialName("lessons_list")
    override val lessonsList: List<LessonData> = listOf()
) : LessonsDomain