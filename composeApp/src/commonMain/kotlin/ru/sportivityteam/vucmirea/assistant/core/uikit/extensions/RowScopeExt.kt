package ru.sportivityteam.vucmirea.assistant.core.uikit.extensions

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme


@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title,
                modifier = Modifier.width(35.dp).height(35.dp)
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AssistantTheme.colors.white,
            selectedTextColor = AssistantTheme.colors.white,
            unselectedIconColor = AssistantTheme.colors.unselectedWhite,
            unselectedTextColor = AssistantTheme.colors.unselectedWhite,
            indicatorColor = Color.Transparent,
        )
    )
}