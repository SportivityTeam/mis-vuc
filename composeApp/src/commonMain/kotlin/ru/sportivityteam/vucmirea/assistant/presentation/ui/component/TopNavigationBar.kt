package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.Navigator
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.screens.settings.SettingsScreen
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(navigator: Navigator) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AssistantTheme.colors.primary,
            titleContentColor = AssistantTheme.colors.white,
            actionIconContentColor = AssistantTheme.colors.white
        ),
        title = {
            Text(text = "Учебный взвод")
        },
        actions = {
            IconButton(onClick = {
                navigator.push(SettingsScreen())
            }) {
                Icon(
                    painter = painterResource(id = MR.images.ic_settings.drawableResId),
                    contentDescription = null
                )
            }
        }
    )
}