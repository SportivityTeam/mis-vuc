package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.screens.settings.SettingsScreen
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    navigator: Navigator,
    title: String,
    isNavigationButtonEnable: Boolean = false,
    isActionButtonEnabled: Boolean = false
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AssistantTheme.colors.primary,
            titleContentColor = AssistantTheme.colors.white,
            actionIconContentColor = AssistantTheme.colors.white,
            navigationIconContentColor = AssistantTheme.colors.white
        ),
        navigationIcon = {
            if (isNavigationButtonEnable) {
                IconButton(onClick = {
                    navigator.pop()
                }) {
                    Icon(
                        painter = painterResource(id = MR.images.ic_arrow_back.drawableResId),
                        contentDescription = null
                    )
                }
            }
        },
        title = {
            Text(text = title)
        },
        actions = {
            if (isActionButtonEnabled) {
                IconButton(onClick = {
                    navigator.push(SettingsScreen())
                }) {
                    Icon(
                        modifier = Modifier.width(35.dp).height(35.dp),
                        imageVector = ImageVector.vectorResource(id = MR.images.ic_settings.drawableResId),
                        contentDescription = null
                    )
                }
            }
        }
    )
}