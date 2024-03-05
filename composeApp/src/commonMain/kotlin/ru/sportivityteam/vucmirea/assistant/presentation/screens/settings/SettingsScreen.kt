package ru.sportivityteam.vucmirea.assistant.presentation.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BackgroundBox
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseBottomSheet
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseButton
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.IconTextButton
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.TopNavigationBar
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.VSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.WSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

class SettingsScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val navigator = LocalNavigator.currentOrThrow
        val uriHandler = LocalUriHandler.current
        val screenModel = getScreenModel<SettingsSM>()
        val action = screenModel.viewActions().observeAsState()
        val state = screenModel.viewStates().observeAsState()

        action.value?.let {
            when (it) {
                SettingsViewAction.LogOut -> navigator.replace(AuthScreen())
                SettingsViewAction.NavigateToTelegram -> uriHandler.openUri(state.value.telegramUri)
            }
        }

        OnPause {
            screenModel.obtainEvent(SettingsViewEvent.Clear)
        }

        TopNavigationBar(
            navigator,
            title = "Настройки",
            isNavigationButtonEnable = true
        )

        BackgroundBox(
            paddingTop = 0.dp,
            horizontalAlignment = Alignment.Start
        ) {
            SettingsHeader(appVersion = state.value.appVersion)
            IconTextButton(
                iconResId = MR.images.ic_feedback.drawableResId,
                text = "Обратная связь"
            ) {
                screenModel.obtainEvent(SettingsViewEvent.OpenTelegramBottomSheet)
            }
            WSpacer()
            BaseButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 90.dp)
                    .padding(bottom = 20.dp),
                onClick = { screenModel.obtainEvent(SettingsViewEvent.OpenLogoutBottomSheet) },
                text = "Выйти",
                containerColor = Color.Red
            )
        }
        if (state.value.isLogOutBottomSheetOpen) {
            BaseBottomSheet(onDismissRequest = {
                screenModel.obtainEvent(SettingsViewEvent.CloseLogOutBottomSheet)
            }, header = "Выход из аккаунта", description = "Вы уверены, что хотите выйти?") {
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    onClick = { screenModel.obtainEvent(SettingsViewEvent.LogOut) },
                    text = "Выйти",
                    containerColor = Color.Red
                )
                VSpacer(size = 15.dp)
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    onClick = { screenModel.obtainEvent(SettingsViewEvent.CloseLogOutBottomSheet) },
                    text = "Отмена",
                    containerColor = AssistantTheme.colors.disable
                )
            }
        }
        if (state.value.isTelegramBottomSheetOpen) {
            BaseBottomSheet(
                onDismissRequest = {
                    screenModel.obtainEvent(SettingsViewEvent.CloseTelegramBottomSheet)
                },
                header = "Чат в Telegram",
                description = "При некорректном отображении расписания или неисправностях в приложении сообщите в чат беседу"
            ) {
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    onClick = { screenModel.obtainEvent(SettingsViewEvent.OpenTelegram) },
                    text = "Перейти в чат"
                )
            }
        }
    }

    @Composable
    private fun SettingsHeader(appVersion: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                painter = painterResource(MR.images.img_mirea_logo.drawableResId),
                contentDescription = null
            )
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Text(
                    text = "Ассистент ВУЦ МИРЭА",
                    style = AssistantTheme.typography.p1,
                    color = AssistantTheme.colors.white
                )
                VSpacer(size = 20.dp)
                Text(
                    text = "Версия: $appVersion",
                    style = AssistantTheme.typography.p2,
                    color = AssistantTheme.colors.white
                )
            }
        }
    }
}