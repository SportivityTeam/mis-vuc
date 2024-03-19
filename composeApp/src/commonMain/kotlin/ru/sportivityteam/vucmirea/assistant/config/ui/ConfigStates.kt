package ru.sportivityteam.vucmirea.assistant.config.ui

sealed class ConfigViewAction {
    data object NavigateToHomeScreen : ConfigViewAction()
    data object NavigateToAuthScreen : ConfigViewAction()
}