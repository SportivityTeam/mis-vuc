package ru.sportivityteam.vucmirea.assistant.di

import org.koin.core.module.Module
import ru.sportivityteam.vucmirea.assistant.core.ktor.ktorModule

internal fun appModule(): List<Module> {
    val modulesList = mutableListOf(
        repositoryModule,
        screenModelsModule,
        platformDatastoreModule,
        platformDatabaseModule,
        ktorModule,
        firebaseModule,
        apiModule
    )
    modulesList.addAll(useCaseModule)

    return modulesList.toList()
}