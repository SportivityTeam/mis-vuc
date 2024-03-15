package ru.sportivityteam.vucmirea.assistant.home.schedule.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.usecase.GetLessonByGroupNumberUseCase
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.usecase.GetLessonByGroupNumberUseCaseImpl

internal val scheduleUseCaseModule = module {
    factory<GetLessonByGroupNumberUseCase> { GetLessonByGroupNumberUseCaseImpl(get()) }
}