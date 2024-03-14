package ru.sportivityteam.vucmirea.assistant.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.core.datastore.dataStorePreferences

private val commonDatastoreModule = module {
    single<DataStore<Preferences>> { dataStorePreferences(null, emptyList(), null) }
}

val coreDatastoreModule: Module
    get() = module {
        includes(commonDatastoreModule + platformDatastoreModule)
    }

internal expect val platformDatastoreModule: Module