package ru.sportivityteam.vucmirea.assistant.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.core.datastore.dataStorePreferences


internal actual val platformDatastoreModule: Module = module {
    single<DataStore<Preferences>> { dataStorePreferences(null, emptyList(), androidContext()) }
}