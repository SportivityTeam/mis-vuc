package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SplashSM>()
        val viewAction = screenModel.viewActions().observeAsState()

        viewAction.value?.let { action ->
            when (action) {
                is SplashAction.navigateToAuthScreen -> rootController.push(AuthScreen())
                is SplashAction.navigateToHomeScreen -> {}
            }
        }
        
        Text(text = "HELLO SPLASH")
    }
}