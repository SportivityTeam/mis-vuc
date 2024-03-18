package ru.sportivityteam.vucmirea.assistant.home.employee.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository.EmployeeRepository

interface GetEmployeeUseCase : suspend () -> Flow<State<List<EmployeeDomain?>>>

class GetEmployeeUseCaseImpl(private val employeeRepository: EmployeeRepository) :
    GetEmployeeUseCase {
    override suspend fun invoke(): Flow<State<List<EmployeeDomain?>>> =
        employeeRepository.getEmployee()
}