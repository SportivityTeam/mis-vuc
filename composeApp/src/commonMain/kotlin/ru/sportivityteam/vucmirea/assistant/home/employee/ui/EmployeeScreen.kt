package ru.sportivityteam.vucmirea.assistant.home.employee.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.getScreenModel
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.EmployeeCard
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

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