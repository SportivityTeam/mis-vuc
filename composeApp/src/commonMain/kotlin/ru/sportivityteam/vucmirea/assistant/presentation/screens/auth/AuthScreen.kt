package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.HomeScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.AuthCard
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.ButtonSize
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.ButtonSlot
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.PrimaryButton
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.VSpacer
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState
import ru.sportivityteam.vucmirea.assistant.theme.AssistantTheme

class AuthScreen : BaseScreen() {
    @Composable
    override fun ScreenContent() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<AuthSM>()
        val action = screenModel.viewActions().observeAsState()
        val state = screenModel.viewStates().observeAsState()

        action.value?.let {
            when (it) {
                is AuthAction.NavigateToHomeScreen -> {
                    rootController.push(HomeScreen())
                }
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
                .padding(top = 25.dp, bottom = 50.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = MR.images.img_background.drawableResId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
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
                    text = state.value.name
                ) {
                    screenModel.setName(it)
                }
                VSpacer(size = 15.dp)
                AuthCard(
                    label = "Ваш номер взвода",
                    text = state.value.groupNumber
                ) {
                    screenModel.setGroup(it)
                }
                VSpacer(size = 30.dp)
                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        screenModel.obtainEvent(AuthEvent.AuthClick)
                        hideKeyboard()
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
}