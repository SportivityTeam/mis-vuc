package ru.sportivityteam.vucmirea.assistant.home.schedule.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.schedule.data.entity.LessonsData
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.LessonsDomain
import ru.sportivityteam.vucmirea.assistant.lesson.domain.entity.LessonDomain

interface ScheduleRepository {
    suspend fun getLessonsByGroupNumber(groupNumber:String): Flow<State<LessonsDomain>>
}