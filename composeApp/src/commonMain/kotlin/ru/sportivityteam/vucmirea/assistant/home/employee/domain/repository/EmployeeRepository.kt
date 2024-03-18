package ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain

interface EmployeeRepository {
     suspend fun configure(): Flow<State<Unit>>
     suspend fun getEmployee(): Flow<State<List<EmployeeDomain?>>>
}