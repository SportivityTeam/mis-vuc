package ru.sportivityteam.vucmirea.assistant.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ru.sportivityteam.vucmirea.assistant.presentation.navigation.BottomBar
import ru.sportivityteam.vucmirea.assistant.presentation.navigation.TimetableTab
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen

class HomeScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        TabNavigator(TimetableTab) {
            Scaffold(
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