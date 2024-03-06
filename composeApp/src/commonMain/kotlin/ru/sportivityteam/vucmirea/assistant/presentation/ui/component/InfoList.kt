package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.presentation.entity.InfoFutureItem
import ru.sportivityteam.vucmirea.assistant.presentation.entity.InfoItem
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

@Composable
fun InfoList(
    items: List<InfoItem>,
    futureItems: List<InfoFutureItem>
) = LazyColumn(
    modifier = Modifier.fillMaxSize().background(color = AssistantTheme.colors.darkBlue)
) {
    items(items) { infoItem ->
        Column(
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            VSpacer(size = 10.dp)
            Text(
                text = infoItem.header,
                style = AssistantTheme.typography.h3,
                color = AssistantTheme.colors.white,
                textAlign = TextAlign.Center
            )
            VSpacer(size = 20.dp)
            Text(
                text = infoItem.text,
                style = AssistantTheme.typography.p2,
                color = AssistantTheme.colors.unselectedWhite
            )
        }
    }
    item {
        VSpacer(size = 20.dp)
        Column(
            modifier = Modifier.background(
                color = AssistantTheme.colors.primary,
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
        ) {
            futureItems.forEach { infoFooterItem ->
                IconTextButton(
                    iconResId = infoFooterItem.iconResId,
                    text = infoFooterItem.text,
                    textStyle = AssistantTheme.typography.p2,
                    onClickAction = infoFooterItem.onClickAction
                )
            }
        }
    }
}