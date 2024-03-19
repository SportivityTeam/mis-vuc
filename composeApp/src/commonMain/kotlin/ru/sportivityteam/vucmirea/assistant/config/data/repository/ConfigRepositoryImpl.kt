package ru.sportivityteam.vucmirea.assistant.config.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sportivityteam.vucmirea.assistant.config.domain.repository.ConfigRepository
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository.EmployeeRepository

class ConfigRepositoryImpl(private val employeeRepository: EmployeeRepository) : ConfigRepository {
    override suspend fun configApp(): Flow<State<Unit>> = flow<State<Unit>> {
        emit(State.loading())
        employeeRepository.configure().collect {
            if (it is State.Success) emit(State.success())
        }
    }.flowOn(Dispatchers.IO)
}