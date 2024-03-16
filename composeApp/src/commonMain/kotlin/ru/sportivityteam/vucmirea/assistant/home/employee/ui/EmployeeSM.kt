package ru.sportivityteam.vucmirea.assistant.home.employee.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.usecase.GetEmployeeUseCase
import ru.sportivityteam.vucmirea.assistant.home.employee.ui.entity.toPresentation

class EmployeeSM(
    private val getEmployeeUseCase: GetEmployeeUseCase
) : BaseStateScreenModel<EmployeeViewState, EmployeeViewAction, EmployeeViewEvent>(initialState = EmployeeViewState()) {
    override fun obtainEvent(viewEvent: EmployeeViewEvent) {

    }

    init {
        screenModelScope.launch(Dispatchers.IO) {
            getEmployeeUseCase.invoke().collect {
                when (it) {
                    is State.Loading -> viewState = viewState.copy(isLoading = true)
                    is State.Success -> {
                        viewState =
                            viewState.copy(employeeList = it.data!!.map { employee ->
                                employee!!.toPresentation()
                            })
                    }

                    is State.Failed -> println(it.message)
                }
            }
        }
    }
}