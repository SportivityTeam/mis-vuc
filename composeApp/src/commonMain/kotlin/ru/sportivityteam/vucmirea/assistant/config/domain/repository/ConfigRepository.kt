package ru.sportivityteam.vucmirea.assistant.config.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State

interface ConfigRepository {
    suspend fun configApp(): Flow<State<Unit>>
}