package ru.sportivityteam.vucmirea.assistant.auth.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.AuthUserUseCase
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.core.uikit.extensions.setFilled
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel

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
        screenModelScope.launch {
            when (viewEvent) {
                is AuthEvent.AuthClick -> {
                    authUserUseCase(
                        viewStates().value.userName,
                        viewStates().value.userGroupNumber
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

                is AuthEvent.SetUserName -> {
                    viewState = viewState.copy(userName = viewEvent.name)
                    isNameFilledFlow.setFilled(viewEvent.name)
                }

                is AuthEvent.SetUserGroup -> {
                    viewState = viewState.copy(userGroupNumber = viewEvent.group)
                    isGroupFilledFlow.setFilled(viewEvent.group)
                }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        viewState = viewState.copy(isLoading = isLoading)
    }
}