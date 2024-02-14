package ru.sportivityteam.vucmirea.assistant.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository
import ru.sportivityteam.vucmirea.assistant.domain.util.State


interface AuthUserUseCase : suspend (String, String) -> Flow<State<Unit>>

class AuthUserUseCaseImpl(
    private val authRepository: AuthRepository
) : AuthUserUseCase {
    override suspend operator fun invoke(name: String, group: String) =
        authRepository.authUser(name, group)
}