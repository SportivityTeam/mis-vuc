package ru.sportivityteam.vucmirea.assistant.di

import ru.sportivityteam.vucmirea.assistant.core.ktor.ktorModule
import ru.sportivityteam.vucmirea.assistant.home.schedule.di.scheduleUseCaseModule

internal fun appModule() =
    listOf(
        repositoryModule,
        useCaseModule,
        screenModelsModule,
        platformDatastoreModule,
        ktorModule,
        scheduleUseCaseModule,
        apiModule
    )