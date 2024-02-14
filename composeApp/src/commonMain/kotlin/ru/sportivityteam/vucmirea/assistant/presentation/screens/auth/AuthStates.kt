package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth


data class AuthViewState(
    val buttonActivated: Boolean = false,
    val name: String = "",
    val groupNumber: String = "",
    val isLoading: Boolean = false
)

sealed class AuthAction {
    data object NavigateToHomeScreen : AuthAction()
    data object ShowError : AuthAction()
}

sealed class AuthEvent {
    data object AuthClick : AuthEvent()
}