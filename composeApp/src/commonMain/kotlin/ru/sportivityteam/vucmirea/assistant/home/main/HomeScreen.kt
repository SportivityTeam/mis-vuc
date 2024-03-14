package ru.sportivityteam.vucmirea.assistant.home.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ru.sportivityteam.vucmirea.assistant.home.main.navigation.BottomBar
import ru.sportivityteam.vucmirea.assistant.home.main.navigation.TimetableTab
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.TopNavigationBar
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

class HomeScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val navigator = LocalNavigator.currentOrThrow
        TabNavigator(TimetableTab) {
            Scaffold(
                containerColor = AssistantTheme.colors.primary,
                topBar = {
                    TopNavigationBar(
                        navigator,
                        title = "Учебный взвод",
                        isActionButtonEnabled = true
                    )
                },
                content = {
                    Box(modifier = Modifier.padding(it)) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomBar()
                }
            )
        }
    }
}