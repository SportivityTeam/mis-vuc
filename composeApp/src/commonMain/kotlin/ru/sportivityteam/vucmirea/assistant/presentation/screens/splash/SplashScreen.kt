package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

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
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState

class SplashScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SplashSM>()
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
                is SplashAction.navigateToAuthScreen -> rootController.push(AuthScreen())
                is SplashAction.navigateToHomeScreen -> {}
            }
        }
    }
}