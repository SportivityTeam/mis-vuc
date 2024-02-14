package ru.sportivityteam.vucmirea.assistant

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import ru.sportivityteam.vucmirea.assistant.presentation.screens.splash.SplashScreen
import ru.sportivityteam.vucmirea.assistant.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Navigator(SplashScreen())
}
