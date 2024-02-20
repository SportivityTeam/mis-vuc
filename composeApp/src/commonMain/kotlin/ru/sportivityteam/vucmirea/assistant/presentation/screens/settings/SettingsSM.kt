package ru.sportivityteam.vucmirea.assistant.presentation.screens.settings

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class SettingsSM : BaseStateScreenModel<SettingsViewState, SettingsViewAction, SettingsViewEvent>
    (initialState = SettingsViewState()) {
    override fun obtainEvent(viewEvent: SettingsViewEvent) {
        when (viewEvent) {
            SettingsViewEvent.LogOut -> {}
            SettingsViewEvent.OpenTelegram -> viewAction = SettingsViewAction.NavigateToTelegram
        }
    }
}