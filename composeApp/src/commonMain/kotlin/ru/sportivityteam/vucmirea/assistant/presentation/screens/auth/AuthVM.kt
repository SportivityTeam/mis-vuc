package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth

import com.adeo.kviewmodel.BaseSharedViewModel

class AuthVM : BaseSharedViewModel<AuthViewState, AuthAction, AuthEvent>(initialState = AuthViewState()) {
    override fun obtainEvent(viewEvent: AuthEvent) {
        TODO("Not yet implemented")
    }
}