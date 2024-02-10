package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState

class SplashScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SplashSM>()
        val viewAction = screenModel.viewActions().observeAsState()

        viewAction.value?.let { action ->
            when (action) {
                is SplashAction.navigateToAuthScreen -> rootController.push(AuthScreen())
                is SplashAction.navigateToHomeScreen -> {}
            }
        }
    }
}