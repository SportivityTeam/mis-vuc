package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.timetable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen

class TimetableScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "Распсиание")
        }
    }
}