package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

sealed class SplashViewState {
    data object Init : SplashViewState()
}

sealed class SplashAction {
    data object navigateToHomeScreen : SplashAction()
    data object navigateToAuthScreen : SplashAction()
}

sealed class SplashEvent {}
