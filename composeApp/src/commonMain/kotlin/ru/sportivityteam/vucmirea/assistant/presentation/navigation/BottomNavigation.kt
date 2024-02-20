package ru.sportivityteam.vucmirea.assistant.presentation.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee.EmployeeScreen
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info.InfoScreen
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.timetable.TimetableScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.extensions.TabNavigationItem
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

object TimetableTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(MR.images.ic_timetable.drawableResId)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Расписание",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(TimetableScreen())
    }
}

object InfoTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(MR.images.ic_info.drawableResId)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Информация",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(InfoScreen())
    }
}

object EmployeeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = painterResource(MR.images.ic_employee.drawableResId)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Работники",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(EmployeeScreen())
    }
}


@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = AssistantTheme.colors.primary
    ) {
        TabNavigationItem(InfoTab)
        TabNavigationItem(TimetableTab)
        TabNavigationItem(EmployeeTab)
    }
}