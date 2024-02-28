package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.getScreenModel
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.EmployeeCard
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

class EmployeeScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val screenModel = getScreenModel<EmployeeSM>()
        val state = screenModel.viewStates().observeAsState()
        val employeeList = remember { state.value.employeeList }

        LazyColumn(
            modifier = Modifier.fillMaxSize().background(color = AssistantTheme.colors.darkBlue)
        ) {
            items(employeeList) { employee ->
                EmployeeCard(employee)
            }
        }
    }
}