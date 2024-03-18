package ru.sportivityteam.vucmirea.assistant.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.core.database.Database
import ru.sportivityteam.vucmirea.assistant.core.database.DatabaseDriver

private val commonDatabaseModule = module {
    single<Database> { Database(DatabaseDriver(null).provideDbDriver()) }
}

val coreDatabaseModule: Module
    get() = module {
        includes(commonDatabaseModule + platformDatabaseModule)
    }

internal expect val platformDatabaseModule: Module