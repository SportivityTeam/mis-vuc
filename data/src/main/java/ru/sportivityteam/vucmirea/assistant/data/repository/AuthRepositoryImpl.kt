package ru.sportivityteam.vucmirea.assistant.data.repository

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository
import ru.sportivityteam.vucmirea.assistant.domain.util.State

@ExperimentalSettingsApi
class AuthRepositoryImpl : AuthRepository {
    private val settings: SuspendSettings = Settings().toSuspendSettings(Dispatchers.IO)

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
        settings.putBoolean(USER_SETTINGS_KEY, true)
        emit(State.success())
    }.flowOn(Dispatchers.IO)

    private val USER_SETTINGS_KEY = "user_settings_key"
}