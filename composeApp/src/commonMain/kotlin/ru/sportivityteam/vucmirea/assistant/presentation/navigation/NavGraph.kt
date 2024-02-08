package ru.sportivityteam.vucmirea.assistant.presentation.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen

fun RootComposeBuilder.navigationGraph() {
    screen("splash") {}
    screen("auth") { AuthScreen() }
    screen("home") {}
}