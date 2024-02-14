package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.theme.AppTheme
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme


@Composable
fun AuthLabel(
    label: String
) {
    Text(
        text = label,
        style = AssistantTheme.typography.p1,
        color = AssistantTheme.colors.secondaryText
    )
}

@Composable
fun AuthCard(
    label: String,
    text: String,
    onValueChange: (String) -> Unit
) {
    val textFieldColors = TextFieldDefaults.colors(
        focusedTextColor = AssistantTheme.colors.tertiary,
        unfocusedTextColor = AssistantTheme.colors.tertiary,
        focusedContainerColor = AssistantTheme.colors.secondary,
        unfocusedContainerColor = AssistantTheme.colors.secondary,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedLabelColor = AssistantTheme.colors.accent,
        unfocusedLabelColor = AssistantTheme.colors.accent,
        cursorColor = AssistantTheme.colors.accent
    )
    return AppTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 5.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = AssistantTheme.colors.secondary
            ),
            shape = AssistantTheme.shape.cornersStyle,
        ) {
            TextField(
                modifier = Modifier.height(48.dp),
                value = text,
                textStyle = AssistantTheme.typography.p2,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                placeholder = { AuthLabel(label) },
                colors = textFieldColors,
            )
        }
    }
}
