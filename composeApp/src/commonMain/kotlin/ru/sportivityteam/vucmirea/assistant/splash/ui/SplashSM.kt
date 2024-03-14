package ru.sportivityteam.vucmirea.assistant.splash.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCase
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseScreenModel

class SplashSM(
    private val getUserLoginUseCase: GetUserLoginUseCase
) : BaseScreenModel<SplashAction>() {
    init {
        screenModelScope.launch {
            getUserLoginUseCase().collect { state ->
                if (state is State.Success) viewAction = SplashAction.NavigateToHomeScreen
                else if (state is State.Failed) viewAction = SplashAction.NavigateToAuthScreen
            }
        }
    }
}