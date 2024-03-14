package ru.sportivityteam.vucmirea.assistant.datastore

import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import ru.sportivityteam.vucmirea.assistant.core.datastore.SETTINGS_PREFERENCES
import ru.sportivityteam.vucmirea.assistant.core.datastore.createDataStoreWithDefaults
import ru.sportivityteam.vucmirea.assistant.util.applicationContext
import java.io.File

actual fun dataStorePreferences(
    corruptionHandler: ReplaceFileCorruptionHandler<Preferences>?,
    coroutineScope: CoroutineScope,
    migrations: List<DataMigration<Preferences>>,
): DataStore<Preferences> = createDataStoreWithDefaults(
    corruptionHandler = corruptionHandler,
    migrations = migrations,
    coroutineScope = coroutineScope,
    path = {
        File(applicationContext.filesDir, "datastore/$SETTINGS_PREFERENCES").path
    }
)