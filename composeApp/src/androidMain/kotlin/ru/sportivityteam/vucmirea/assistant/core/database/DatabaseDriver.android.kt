package ru.sportivityteam.vucmirea.assistant.core.database

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver


actual class DatabaseDriver(private val context: Context? = null) {
    actual fun provideDbDriver(
    ): SqlDriver {
        return AndroidSqliteDriver(Database.Schema.synchronous(), context!!, "assistant.db")
    }
}