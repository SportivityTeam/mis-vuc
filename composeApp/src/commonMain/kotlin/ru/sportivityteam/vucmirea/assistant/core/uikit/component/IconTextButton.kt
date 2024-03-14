package ru.sportivityteam.vucmirea.assistant.core.uikit.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

@Composable
fun IconTextButton(
    iconResId: Int,
    text: String,
    textStyle: TextStyle = AssistantTheme.typography.h3,
    onClickAction: () -> Unit
) = Row(
    modifier = Modifier.clickable { onClickAction() }.padding(horizontal = 10.dp)
        .padding(top = 5.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        tint = AssistantTheme.colors.white,
        modifier = Modifier
            .height(36.dp)
            .width(36.dp)
            .padding(end = 10.dp)
    )
    Text(text = text, style = textStyle, color = AssistantTheme.colors.white)
}