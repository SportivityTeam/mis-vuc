package ru.sportivityteam.vucmirea.assistant.core.uikit.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

@Composable
fun BaseButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    containerColor: Color = AssistantTheme.colors.accent,
) = androidx.compose.material3.Button(
    modifier = modifier.height(40.dp), onClick = onClick, colors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = AssistantTheme.colors.white
    )
) {
    Text(text = text, style = AssistantTheme.typography.p1)
}