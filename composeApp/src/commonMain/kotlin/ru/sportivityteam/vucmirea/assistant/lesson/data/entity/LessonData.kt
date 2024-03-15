package ru.sportivityteam.vucmirea.assistant.lesson.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.sportivityteam.vucmirea.assistant.lesson.domain.entity.LessonDomain

@Serializable
data class LessonData(
    @SerialName("id")
    override val id: String,
    @SerialName("audience")
    override val audience: String,
    @SerialName("lesson")
    override val lesson: String,
    @SerialName("employee")
    override val employee: String,
    @SerialName("lesson_time")
    override val lessonTime: String
) : LessonDomain