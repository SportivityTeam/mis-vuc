package ru.sportivityteam.vucmirea.assistant.config.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.config.domain.usecase.ConfigAppUseCase
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseScreenModel
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCase

class ConfigSM(
    private val getUserLoginUseCase: GetUserLoginUseCase,
    private val configAppUseCase: ConfigAppUseCase
) : BaseScreenModel<ConfigViewAction>() {

    init {
        screenModelScope.launch {
            getUserLoginUseCase().collect { state ->
                if (state is State.Success) viewAction = ConfigViewAction.NavigateToHomeScreen
                else if (state is State.Failed) startConfig()
            }

        }
    }

    private suspend fun startConfig() {
        configAppUseCase.invoke().collect { state ->
            if (state is State.Success) viewAction = ConfigViewAction.NavigateToAuthScreen
        }
    }
}