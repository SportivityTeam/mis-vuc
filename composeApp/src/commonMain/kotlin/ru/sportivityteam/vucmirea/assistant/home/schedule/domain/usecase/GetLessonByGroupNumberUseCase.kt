package ru.sportivityteam.vucmirea.assistant.home.schedule.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity.LessonsDomain
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.repository.ScheduleRepository

interface GetLessonByGroupNumberUseCase : suspend (String) -> Flow<State<LessonsDomain>>
class GetLessonByGroupNumberUseCaseImpl(private val scheduleRepository: ScheduleRepository) :
    GetLessonByGroupNumberUseCase {
    override suspend fun invoke(p1: String) = scheduleRepository.getLessonsByGroupNumber(p1)
}