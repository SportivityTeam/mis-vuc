package ru.sportivityteam.vucmirea.assistant.presentation.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.screens.splash.SplashScreen

fun RootComposeBuilder.navigationGraph() {
    screen(NavigationTree.Splash.name) { SplashScreen() }
    screen(NavigationTree.Auth.name) { AuthScreen() }
    screen(NavigationTree.Home.name) {}
}