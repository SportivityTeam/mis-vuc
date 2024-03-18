package ru.sportivityteam.vucmirea.assistant.core.database

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriver {
    fun provideDbDriver(
    ): SqlDriver
}

const val DB_NAME = "mis-vuc.db"
