package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.AuthUserUseCase
import ru.sportivityteam.vucmirea.assistant.domain.util.State
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class AuthSM(
    private val authUserUseCase: AuthUserUseCase
) : BaseStateScreenModel<AuthViewState, AuthAction, AuthEvent>(initialState = AuthViewState()) {
    private val isNameFilledFlow = MutableStateFlow(value = false)
    private val isGroupFilledFlow = MutableStateFlow(value = false)

    init {
        screenModelScope.launch {
            isNameFilledFlow.combine(isGroupFilledFlow) { isNameFiled, isGroupFiled ->
                viewState = if (isNameFiled && isGroupFiled)
                    viewState.copy(isButtonActivated = true)
                else
                    viewState.copy(isButtonActivated = false)
            }.collect()
        }
    }

    override fun obtainEvent(viewEvent: AuthEvent) {
        when (viewEvent) {
            is AuthEvent.AuthClick -> {
                screenModelScope.launch {
                    authUserUseCase(
                        viewStates().value.name,
                        viewStates().value.groupNumber
                    ).collect {
                        when (it) {
                            is State.Loading -> setLoading(true)
                            is State.Failed -> {
                                setLoading(false)
                            }

                            is State.Success -> {
                                setLoading(false)
                                viewAction = AuthAction.NavigateToHomeScreen
                            }
                        }
                    }
                }
            }
        }
    }

    fun setName(newName: String) {
        screenModelScope.launch {
            viewState = viewState.copy(name = newName)
            if (newName.isNotEmpty()) isNameFilledFlow.emit(value = true)
            else isNameFilledFlow.emit(value = false)
        }
    }

    fun setGroup(newGroup: String) {
        screenModelScope.launch {
            viewState = viewState.copy(groupNumber = newGroup)
            if (newGroup.isNotEmpty()) isGroupFilledFlow.emit(value = true)
            else isGroupFilledFlow.emit(value = false)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        viewState = viewState.copy(isLoading = isLoading)
    }
}