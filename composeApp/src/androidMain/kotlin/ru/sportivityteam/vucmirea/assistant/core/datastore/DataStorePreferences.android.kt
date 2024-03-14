package ru.sportivityteam.vucmirea.assistant.core.datastore

import android.content.Context
import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import java.io.File

actual fun dataStorePreferences(
    corruptionHandler: ReplaceFileCorruptionHandler<Preferences>?,
    migrations: List<DataMigration<Preferences>>,
    context: Any?
): DataStore<Preferences> = createDataStoreWithDefaults(
    corruptionHandler = corruptionHandler,
    migrations = migrations,
    context = context,
    path = {mContext ->
        if(mContext == null)
            throw IllegalStateException("You must provide context for Android")
        else File((mContext as Context).filesDir, "datastore/$SETTINGS_PREFERENCES").path
    }
)