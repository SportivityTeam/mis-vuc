package ru.sportivityteam.vucmirea.assistant.home.schedule.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.schedule.data.api.ScheduleApi
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.LessonsDomain
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl(private val scheduleApi: ScheduleApi) : ScheduleRepository {
    override suspend fun getLessonsByGroupNumber(groupNumber: String): Flow<State<LessonsDomain>> =
        flow {
            emit(State.loading())
            val result = scheduleApi.getLessonsByGroupId()
            emit(State.success(result))
        }
}