package ru.sportivityteam.vucmirea.assistant.presentation.screens.settings

data class SettingsViewState(
    val isLoading: Boolean = false,
    val appVersion: String = "",
    val telegramUri:String = "https://t.me/+NMT-uTngy2w1MDA6"
)

sealed class SettingsViewAction {
    data object NavigateToTelegram : SettingsViewAction()
    data object LogOut : SettingsViewAction()
}

sealed class SettingsViewEvent {
    data object LogOut : SettingsViewEvent()

    data object OpenTelegram : SettingsViewEvent()
}