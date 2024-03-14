package ru.sportivityteam.vucmirea.assistant.auth.domain

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State

interface AuthRepository {
    val isUserLogin: Flow<State<Boolean>>
    suspend fun authUser(name: String, group: String): Flow<State<Unit>>

    suspend fun logout(): Flow<State<Unit>>
}