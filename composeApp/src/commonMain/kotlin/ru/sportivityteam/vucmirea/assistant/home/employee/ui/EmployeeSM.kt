package ru.sportivityteam.vucmirea.assistant.home.employee.ui

import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel

class EmployeeSM: BaseStateScreenModel<EmployeeViewState, EmployeeViewAction, EmployeeViewEvent>(initialState = EmployeeViewState()) {
    override fun obtainEvent(viewEvent: EmployeeViewEvent) {

    }
}