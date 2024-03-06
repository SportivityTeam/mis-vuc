package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import ru.sportivityteam.vucmirea.assistant.presentation.entity.EmployeePresentation
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

@Composable
fun EmployeeCard(
    employee: EmployeePresentation
) {
    Row(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp, vertical = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(percent = 20))
                .weight(weight = 1f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(employee.imageUri)
                .build(),
            filterQuality = FilterQuality.None,
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxWidth().weight(weight = 2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = employee.fullName,
                textAlign = TextAlign.Center,
                style = AssistantTheme.typography.p1,
                color = AssistantTheme.colors.white
            )
            VSpacer(size = 10.dp)
            Text(
                text = employee.jobTitle,
                textAlign = TextAlign.Center,
                style = AssistantTheme.typography.p3,
                color = AssistantTheme.colors.unselectedWhite
            )
            VSpacer(size = 10.dp)
            Column(
                modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = employee.email,
                    style = AssistantTheme.typography.p4,
                    color = AssistantTheme.colors.unselectedWhite
                )
                Text(
                    text = "${employee.phone} доб. ${employee.phoneAdd}",
                    style = AssistantTheme.typography.p4,
                    color = AssistantTheme.colors.unselectedWhite
                )
                Text(
                    text = employee.audience,
                    style = AssistantTheme.typography.p4,
                    color = AssistantTheme.colors.unselectedWhite
                )
            }
        }
    }
}