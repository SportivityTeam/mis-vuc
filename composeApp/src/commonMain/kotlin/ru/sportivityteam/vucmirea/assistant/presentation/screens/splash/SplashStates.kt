package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

data class SplashViewState(
    val loading: Boolean = false
)

sealed class SplashAction {
    data object navigateToHomeScreen : SplashAction()
    data object navigateToAuthScreen : SplashAction()
}

sealed class SplashEvennt{}
