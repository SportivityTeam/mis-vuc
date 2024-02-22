package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    onDismissRequest: () -> Unit,
    header: String,
    description: String,
    content: @Composable (ColumnScope.() -> Unit),
) = ModalBottomSheet(
    onDismissRequest = onDismissRequest,
    containerColor = AssistantTheme.colors.tertiary
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = header,
            color = AssistantTheme.colors.white,
            style = AssistantTheme.typography.h3
        )
        VSpacer(size = 20.dp)
        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = description,
            color = AssistantTheme.colors.white,
            style = AssistantTheme.typography.p2,
            textAlign = TextAlign.Center
        )
        VSpacer(size = 40.dp)
        content()
        VSpacer(size = 65.dp)
    }
}