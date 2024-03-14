package ru.sportivityteam.vucmirea.assistant.auth.ui


data class AuthViewState(
    val isButtonActivated: Boolean = false,
    val userName: String = "",
    val userGroupNumber: String = "",
    val isLoading: Boolean = false
)

sealed class AuthAction {
    data object NavigateToHomeScreen : AuthAction()
}

sealed class AuthEvent {
    data object AuthClick : AuthEvent()
    data class SetUserName(val name: String) : AuthEvent()

    data class SetUserGroup(val group: String) : AuthEvent()
}