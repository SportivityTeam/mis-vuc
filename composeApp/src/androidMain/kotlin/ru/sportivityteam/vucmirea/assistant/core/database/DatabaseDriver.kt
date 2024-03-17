package ru.sportivityteam.vucmirea.assistant.core.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.sportivityteam.vucmirea.assistant.AssistantDatabase

actual class DatabaseDriver(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = AssistantDatabase.Schema,
        context = context,
        name = DB_NAME
    )
}