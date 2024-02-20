package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

@Composable
fun BackgroundBox(
    paddingTop: Dp = 25.dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable (ColumnScope.() -> Unit)
) = Box(
    Modifier
        .fillMaxSize()
        .padding(horizontal = 15.dp)
        .padding(top = paddingTop, bottom = 50.dp)
        .clip(AssistantTheme.shape.cornersStyle)
) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = MR.images.img_background.drawableResId),
        contentScale = ContentScale.Crop,
        contentDescription = null,
    )
    Column(
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = Arrangement.Top
    ) {
        content()
    }
}