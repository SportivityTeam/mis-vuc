package ru.sportivityteam.vucmirea.assistant.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import ru.sportivityteam.vucmirea.assistant.splash.ui.SplashScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Navigator(SplashScreen())
}
