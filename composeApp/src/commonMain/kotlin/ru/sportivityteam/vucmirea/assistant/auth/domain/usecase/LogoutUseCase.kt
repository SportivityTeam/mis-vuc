package ru.sportivityteam.vucmirea.assistant.auth.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.auth.domain.AuthRepository
import ru.sportivityteam.vucmirea.assistant.core.util.State

interface LogoutUseCase : suspend () -> Flow<State<Unit>>

class LogoutUseCaseImpl(private val authRepository: AuthRepository) : LogoutUseCase {
    override suspend operator fun invoke() = authRepository.logout()
}