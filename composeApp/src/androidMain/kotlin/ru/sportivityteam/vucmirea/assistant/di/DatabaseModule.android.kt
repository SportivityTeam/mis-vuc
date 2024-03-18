package ru.sportivityteam.vucmirea.assistant.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.core.database.Database
import ru.sportivityteam.vucmirea.assistant.core.database.DatabaseDriver

internal actual val platformDatabaseModule: Module = module {
    single<Database> { Database(DatabaseDriver(androidContext()).provideDbDriver()) }
}