package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.entity.LessonPresentation
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme


@Composable
fun TimetableListItem(
    modifier: Modifier,
    index: Int,
    lesson: LessonPresentation
) {
    Box(modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(MR.images.lesson_background.drawableResId),
            contentDescription = null, contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "$index пара",
                    style = AssistantTheme.typography.p3,
                    color = AssistantTheme.colors.white
                )
                WSpacer()
                Text(
                    text = lesson.lessonTime,
                    style = AssistantTheme.typography.p3,
                    color = AssistantTheme.colors.white
                )
            }
            VSpacer(size = 12.dp)
            Text(
                text = lesson.lesson,
                style = AssistantTheme.typography.h4
            )
            Row(Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                Text(
                    text = lesson.employee,
                    style = AssistantTheme.typography.p3
                )
                WSpacer()
                Text(
                    text = lesson.audience,
                    style = AssistantTheme.typography.p3
                )
            }
        }
    }
}