package ru.sportivityteam.vucmirea.assistant.domain.usecase.auth

import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository

class AuthUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(name: String, group: String) = authRepository.authUser(name, group)
}