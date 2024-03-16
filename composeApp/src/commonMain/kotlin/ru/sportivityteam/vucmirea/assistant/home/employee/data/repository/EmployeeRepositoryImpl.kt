package ru.sportivityteam.vucmirea.assistant.home.employee.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.sportivityteam.vucmirea.assistant.core.firebase.FirestoreUtil
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.data.entity.EmployeeData
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository.EmployeeRepository

class EmployeeRepositoryImpl(private val firestoreUtil: FirestoreUtil) : EmployeeRepository {
    override suspend fun getEmployee(): Flow<State<List<EmployeeDomain?>>> =
        flow<State<List<EmployeeDomain?>>> {
            emit(State.loading())
            firestoreUtil.getCollection(EMPLOYEE_COLLECTION)
                .collect { query ->
                    val result = query.documents.map {
                        it.data<EmployeeData>()
                    }
                    emit(State.success(result))
                }

        }.catch { emit(State.failed(it.message)) }.flowOn(Dispatchers.IO)

    private companion object {
        private const val EMPLOYEE_COLLECTION = "employee"
    }
}