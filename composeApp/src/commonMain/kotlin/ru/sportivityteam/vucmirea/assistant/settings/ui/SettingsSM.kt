package ru.sportivityteam.vucmirea.assistant.settings.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.LogoutUseCase
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel

class SettingsSM(
    private val logoutUseCase: LogoutUseCase
) : BaseStateScreenModel<SettingsViewState, SettingsViewAction, SettingsViewEvent>
    (initialState = SettingsViewState()) {
    override fun obtainEvent(viewEvent: SettingsViewEvent) {
        when (viewEvent) {
            SettingsViewEvent.LogOut -> {
                screenModelScope.launch {
                    logoutUseCase().collect {
                        when (it) {
                            is State.Loading -> viewState =
                                viewState.copy(isLoading = true)

                            is State.Failed -> viewState =
                                viewState.copy(isLoading = false)

                            is State.Success -> {
                                viewState =
                                    viewState.copy(
                                        isLogOutBottomSheetOpen = false,
                                        isLoading = false
                                    )
                                viewAction = SettingsViewAction.LogOut
                            }
                        }
                    }
                }
            }

            SettingsViewEvent.OpenTelegram -> viewAction = SettingsViewAction.NavigateToTelegram

            SettingsViewEvent.OpenLogoutBottomSheet -> viewState =
                viewState.copy(isLogOutBottomSheetOpen = true)

            SettingsViewEvent.CloseLogOutBottomSheet -> viewState =
                viewState.copy(isLogOutBottomSheetOpen = false)

            SettingsViewEvent.OpenTelegramBottomSheet -> viewState =
                viewState.copy(isTelegramBottomSheetOpen = true)


            SettingsViewEvent.CloseTelegramBottomSheet -> viewState =
                viewState.copy(isTelegramBottomSheetOpen = false)

            SettingsViewEvent.Clear -> viewAction = null
        }
    }
}