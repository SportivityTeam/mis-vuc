package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.timetable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.screens.lesson.LessonScreen
import ru.sportivityteam.vucmirea.assistant.presentation.screens.settings.SettingsViewAction
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BackgroundBox
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.TimetableListItem
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.WSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

class TimetableScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<TimetableSM>()
        val action = screenModel.viewActions().observeAsState()
        val state = screenModel.viewStates().observeAsState()

        action.value?.let { viewAction ->
            when (viewAction) {
                is TimetableViewAction.NavigateToLesson ->
                    navigator.replace(LessonScreen(viewAction.lessonId))
            }
        }

        BackgroundBox(
            paddingTop = 0.dp, paddingBottom = 0.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
            ) {
                Text(
                    text = state.value.day,
                    style = AssistantTheme.typography.h3,
                    color = AssistantTheme.colors.white
                )
                WSpacer()
                Text(
                    text = state.value.date,
                    style = AssistantTheme.typography.h3,
                    color = AssistantTheme.colors.white
                )
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
                itemsIndexed(state.value.lessons) { index, lesson ->
                    TimetableListItem(
                        modifier = Modifier.padding(
                            vertical = 10.dp
                        ).clickable {
                            screenModel.obtainEvent(
                                TimetableViewEvent.OpenLesson(lesson.id)
                            )
                        }, index = index + 1, lesson = lesson
                    )
                }
            }
        }
    }
}