package ru.sportivityteam.vucmirea.assistant.data.auth.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.sportivityteam.vucmirea.assistant.domain.auth.repository.AuthRepository
import ru.sportivityteam.vucmirea.assistant.domain.util.State

class AuthRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : AuthRepository {
    private val isUserLoginPrefs =
        booleanPreferencesKey("$PREFS_TAG_KEY$IS_USER_LOGIN")

    override val isUserLogin: Flow<State<Boolean>> = flow<State<Boolean>> {
        emit(State.loading())
        dataStore.data.map { preferences ->
            preferences[isUserLoginPrefs] ?: false
        }.collect { result ->
            if (result) emit(State.success())
            else emit(State.failed())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun authUser(name: String, group: String): Flow<State<Unit>> =
        flow<State<Unit>> {
            emit(State.loading())
            dataStore.edit { preferences ->
                preferences[isUserLoginPrefs] = true
            }
            emit(State.success())
        }.flowOn(Dispatchers.IO)

    override suspend fun logout(): Flow<State<Unit>> = flow<State<Unit>> {
        emit(State.loading())
        dataStore.edit { preferences ->
            preferences[isUserLoginPrefs] = true
        }
        emit(State.success())
    }.flowOn(Dispatchers.IO)

    private companion object {
        private const val PREFS_TAG_KEY = "user_data_store"
        private const val IS_USER_LOGIN = "is_user_login"
    }
}