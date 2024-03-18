package ru.sportivityteam.vucmirea.assistant.home.employee.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import ru.sportivityteam.vucmirea.assistant.core.database.Database
import ru.sportivityteam.vucmirea.assistant.core.firebase.FirestoreUtil
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.data.entity.EmployeeData
import ru.sportivityteam.vucmirea.assistant.home.employee.data.mapper.toDataModelList
import ru.sportivityteam.vucmirea.assistant.home.employee.data.mapper.toStorageModel
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository.EmployeeRepository

class EmployeeRepositoryImpl(
    private val firestoreUtil: FirestoreUtil,
    private val database: Database
) : EmployeeRepository {

    override suspend fun configure(): Flow<State<Unit>> = flow {
        emit(State.loading())
        firestoreUtil.getCollection(EMPLOYEE_COLLECTION)
            .collect { query ->
                val result = query.documents.map {
                    it.data<EmployeeData>()
                }
                storeEmployee(result)
                emit(State.success())
            }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getEmployee(): Flow<State<List<EmployeeDomain?>>> = flow {
        emit(State.loading())
        database.employeeQueries.selectAllEmployee().asFlow()
            .mapToList(currentCoroutineContext()).mapLatest {
                return@mapLatest it.toDataModelList()
            }.catch { emit(State.failed(it.message)) }
            .flowOn(Dispatchers.IO)
            .collect {
                emit(State.success(it))
            }
    }

    private suspend fun storeEmployee(employeeList: List<EmployeeData>) {
        employeeList.forEach { employee ->
            database.employeeQueries.insertEmployee(employee.toStorageModel())
        }
    }

    private companion object {
        private const val EMPLOYEE_COLLECTION = "employee"
    }
}