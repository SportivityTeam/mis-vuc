package ru.sportivityteam.vucmirea.assistant.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository
import ru.sportivityteam.vucmirea.assistant.domain.util.State

interface LogoutUseCase : suspend () -> Flow<State<Unit>>

class LogoutUseCaseImpl(private val authRepository: AuthRepository) : LogoutUseCase{
    override suspend operator fun invoke() = authRepository.logout()
}