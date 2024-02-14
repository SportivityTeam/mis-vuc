package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth


data class AuthViewState(
    val isButtonActivated: Boolean = false,
    val name: String = "",
    val groupNumber: String = "",
    val isLoading: Boolean = false
)

sealed class AuthAction {
    data object NavigateToHomeScreen : AuthAction()
}

sealed class AuthEvent {
    data object AuthClick : AuthEvent()
}