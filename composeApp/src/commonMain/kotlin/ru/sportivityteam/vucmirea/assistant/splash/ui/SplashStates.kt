package ru.sportivityteam.vucmirea.assistant.splash.ui

sealed class SplashAction {
    data object NavigateToHomeScreen : SplashAction()
    data object NavigateToAuthScreen : SplashAction()
}