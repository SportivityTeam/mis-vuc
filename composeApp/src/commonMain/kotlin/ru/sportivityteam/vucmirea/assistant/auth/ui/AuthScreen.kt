package ru.sportivityteam.vucmirea.assistant.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.home.main.HomeScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.AuthCard
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.BackgroundBox
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.ButtonSize
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.ButtonSlot
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.PrimaryButton
import ru.sportivityteam.vucmirea.assistant.core.uikit.component.VSpacer
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

class AuthScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val keyboardController = LocalSoftwareKeyboardController.current
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<AuthSM>()
        val action = screenModel.viewActions().observeAsState()
        val state = screenModel.viewStates().observeAsState()

        action.value?.let {
            when (it) {
                is AuthAction.NavigateToHomeScreen -> {
                    rootController.replace(HomeScreen())
                }
            }
        }
        BackgroundBox {
            Image(
                painter = painterResource(id = MR.images.img_mirea_logo.drawableResId),
                contentDescription = null,
                Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .padding(top = 30.dp)
            )
            VSpacer(size = 100.dp)
            Text(
                text = "Авторизация",
                color = colorResource(MR.colors.white.resourceId),
                style = AssistantTheme.typography.h3
            )
            VSpacer(size = 25.dp)
            AuthCard(
                label = "Ваше имя",
                text = state.value.userName
            ) {
                screenModel.obtainEvent(AuthEvent.SetUserName(it))
            }
            VSpacer(size = 15.dp)
            AuthCard(
                label = "Ваш номер взвода",
                text = state.value.userGroupNumber
            ) {
                screenModel.obtainEvent(AuthEvent.SetUserGroup(it))
            }
            VSpacer(size = 30.dp)
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = {
                    screenModel.obtainEvent(AuthEvent.AuthClick)
                    keyboardController?.hide()
                },
                enabled = state.value.isButtonActivated,
                text = "Войти",
                size = ButtonSize.Normal,
                isProgressBarVisible = state.value.isLoading,
                slotPosition = ButtonSlot.End
            )
        }
    }
}