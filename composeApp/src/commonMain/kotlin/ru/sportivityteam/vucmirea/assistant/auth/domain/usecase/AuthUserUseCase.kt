package ru.sportivityteam.vucmirea.assistant.auth.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.auth.domain.AuthRepository
import ru.sportivityteam.vucmirea.assistant.core.util.State


interface AuthUserUseCase : suspend (String, String) -> Flow<State<Unit>>

class AuthUserUseCaseImpl(
    private val authRepository: AuthRepository
) : AuthUserUseCase {
    override suspend operator fun invoke(name: String, group: String) =
        authRepository.authUser(name, group)
}