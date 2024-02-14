package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

sealed class SplashAction {
    data object NavigateToHomeScreen : SplashAction()
    data object NavigateToAuthScreen : SplashAction()
}