package ru.sportivityteam.vucmirea.assistant.data.auth.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sportivityteam.vucmirea.assistant.domain.auth.repository.AuthRepository
import ru.sportivityteam.vucmirea.assistant.domain.util.State

class AuthRepositoryImpl : AuthRepository {

    override val isUserLogin: Flow<State<Boolean>> = flow<State<Boolean>> {
        emit(State.loading())
        val result = settings.getBoolean(USER_SETTINGS_KEY, false)
        if (result) emit(State.success())
        else emit(State.failed())
    }.flowOn(Dispatchers.IO)

    override suspend fun authUser(name: String, group: String): Flow<State<Unit>> =
        flow<State<Unit>> {
            emit(State.loading())
            settings.putBoolean(USER_SETTINGS_KEY, true)
            emit(State.success())
        }.flowOn(Dispatchers.IO)

    override suspend fun logout(): Flow<State<Unit>> = flow<State<Unit>> {
        emit(State.loading())
        settings.putBoolean(USER_SETTINGS_KEY, false)
        emit(State.success())
    }.flowOn(Dispatchers.IO)

    private val USER_SETTINGS_KEY = "user_settings_key"
}