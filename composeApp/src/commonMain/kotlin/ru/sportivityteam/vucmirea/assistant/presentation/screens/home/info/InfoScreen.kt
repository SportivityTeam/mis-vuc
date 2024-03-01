package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.koin.getScreenModel
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState

class InfoScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val screenModel = getScreenModel<InfoSM>()
        val state = screenModel.viewStates().observeAsState()


    }
}