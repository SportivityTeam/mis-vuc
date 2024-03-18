package ru.sportivityteam.vucmirea.assistant.home.employee.ui

import ru.sportivityteam.vucmirea.assistant.home.employee.ui.entity.EmployeePresentation

data class EmployeeViewState(
    val isLoading: Boolean = false,
    val employeeList: List<EmployeePresentation> = listOf()
)

sealed class EmployeeViewAction {

}

sealed class EmployeeViewEvent {

}