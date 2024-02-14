package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.AuthUserUseCase
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class AuthSM(
    private val authUserUseCase: AuthUserUseCase
) : BaseStateScreenModel<AuthViewState, AuthAction, AuthEvent>(initialState = AuthViewState()) {
    override fun obtainEvent(viewEvent: AuthEvent) {
        when (viewEvent) {
            is AuthEvent.AuthClick -> {
                screenModelScope.launch {
                    authUserUseCase(viewStates().value.name, viewStates().value.groupNumber)
                }
            }
        }
    }

    fun setName(newName: String) {
        viewState = viewState.copy(name = newName)
    }

    fun setGroup(newGroup: String) {
        viewState = viewState.copy(groupNumber = newGroup)
    }
}