package ru.sportivityteam.vucmirea.assistant.config.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.auth.ui.AuthScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.home.main.HomeScreen

class ConfigScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<ConfigSM>()
        val viewAction = screenModel.viewActions().observeAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(MR.images.ic_launcher_playstore.drawableResId),
                contentDescription = null
            )
        }

        viewAction.value?.let { action ->
            when (action) {
                is ConfigViewAction.NavigateToHomeScreen -> rootController.replace(HomeScreen())
                is ConfigViewAction.NavigateToAuthScreen -> rootController.replace(AuthScreen())
            }
        }
    }
}