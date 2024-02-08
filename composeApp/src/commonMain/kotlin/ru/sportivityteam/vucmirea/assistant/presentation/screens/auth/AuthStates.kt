package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth


data class AuthViewState(
    val buttonActivated: Boolean = false
)

sealed class AuthAction {
    data object navigateToHomeScreen : AuthAction()
    data class showError(val errorMessage: String) : AuthAction()
    data object showLoading : AuthAction()
}

sealed class AuthEvent {
    data class authClick(val name: String, val groupNumber: String) : AuthEvent()
}