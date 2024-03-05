package ru.sportivityteam.vucmirea.assistant.presentation.screens.settings

data class SettingsViewState(
    val isLoading: Boolean = false,
    val appVersion: String = "0.0.1",
    val isTelegramBottomSheetOpen: Boolean = false,
    val isLogOutBottomSheetOpen: Boolean = false,
    val telegramUri: String = "https://t.me/c/2085543550/3"
)

sealed class SettingsViewAction {
    data object NavigateToTelegram : SettingsViewAction()
    data object LogOut : SettingsViewAction()
}

sealed class SettingsViewEvent {
    data object LogOut : SettingsViewEvent()
    data object OpenLogoutBottomSheet : SettingsViewEvent()
    data object CloseLogOutBottomSheet : SettingsViewEvent()
    data object OpenTelegram : SettingsViewEvent()
    data object OpenTelegramBottomSheet : SettingsViewEvent()
    data object CloseTelegramBottomSheet : SettingsViewEvent()
    data object Clear: SettingsViewEvent()
}