package ru.sportivityteam.vucmirea.assistant.config.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.config.domain.repository.ConfigRepository
import ru.sportivityteam.vucmirea.assistant.core.util.State

interface ConfigAppUseCase : suspend () -> Flow<State<Unit>>

class ConfigAppUseCaseImpl(private val configRepository: ConfigRepository) : ConfigAppUseCase {
    override suspend fun invoke(): Flow<State<Unit>> = configRepository.configApp()
}