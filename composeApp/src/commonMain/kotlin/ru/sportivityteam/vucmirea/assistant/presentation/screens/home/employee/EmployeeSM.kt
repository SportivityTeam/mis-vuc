package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class EmployeeSM: BaseStateScreenModel<EmployeeViewState, EmployeeViewAction, EmployeeViewEvent>(initialState = EmployeeViewState()) {
    override fun obtainEvent(viewEvent: EmployeeViewEvent) {

    }
}