package ru.sportivityteam.vucmirea.assistant.domain.usecase.auth

import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository

class LogoutUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.logout()
}