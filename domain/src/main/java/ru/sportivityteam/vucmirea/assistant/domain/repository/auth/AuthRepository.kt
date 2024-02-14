package ru.sportivityteam.vucmirea.assistant.domain.repository.auth

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.domain.util.State

interface AuthRepository {
    val isUserLogin: Flow<State<Boolean>>
    suspend fun authUser(name: String, group: String): Flow<State<Unit>>

    suspend fun logout(): Flow<State<Unit>>
}