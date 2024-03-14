package ru.sportivityteam.vucmirea.assistant.lesson.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BackgroundBox
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.TopNavigationBar
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.VSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.WSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

class LessonScreen(lessonId: String) : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<LessonSM>()
        val state = screenModel.viewStates().observeAsState()

        TopNavigationBar(
            navigator,
            title = "Учебный взвод ${state.value.groupNumber}",
            isNavigationButtonEnable = true,
            isActionButtonEnabled = true
        )

        BackgroundBox(
            paddingTop = 0.dp,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = state.value.lesson.audience,
                style = AssistantTheme.typography.p1,
                color = AssistantTheme.colors.white
            )
            Text(
                text = state.value.lesson.lesson,
                style = AssistantTheme.typography.h2,
                color = AssistantTheme.colors.white
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = MR.images.ic_academic_cap.drawableResId),
                    contentDescription = null
                )
                Text(
                    text = state.value.lesson.employee,
                    style = AssistantTheme.typography.h3,
                    color = AssistantTheme.colors.white
                )
            }
            VSpacer(size = 35.dp)
            Text(
                text = "Тактика военно-воздушных сил — составная часть военного искусства ВВС, включающая теорию и практику подготовки и ведения боя авиационным соединением, частью, подразделением, одиночным самолётом (вертолётом). ",
                style = AssistantTheme.typography.p1,
                color = AssistantTheme.colors.white
            )
            WSpacer()
        }
    }
}