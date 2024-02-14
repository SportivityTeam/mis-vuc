package ru.sportivityteam.vucmirea.assistant.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.VSpacer
import ru.sportivityteam.vucmirea.assistant.MR
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.BaseScreen
import ru.sportivityteam.vucmirea.assistant.presentation.ui.component.PrimaryButton
import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.observeAsState

class AuthScreen : BaseScreen() {
    @Preview
    @Composable
    override fun ScreenContent() {
        val rootController = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<AuthSM>()
        val action = screenModel.viewActions().observeAsState()
        val state = screenModel.viewStates().observeAsState()
        val configuration = LocalConfiguration.current

        action.value?.let {
            when (it) {
                is AuthAction.NavigateToHomeScreen -> {

                }

                is AuthAction.ShowError -> {

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
                        .scale(3F)
                        .padding(top = 30.dp)
                )
                VSpacer(size = 135.dp)
                Text(text = "Ваше имя", color = colorResource(MR.colors.white.resourceId))
                TextField(
                    value = state.value.name,
                    onValueChange = { screenModel.setName(it) })
                VSpacer(size = 10.dp)
                Text(text = "Ваш номер взвода", color = colorResource(MR.colors.white.resourceId))
                TextField(
                    value = state.value.name,
                    onValueChange = { screenModel.setGroup(it) })
                VSpacer(size = 25.dp)
                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 90.dp),
                    onClick = {
                        screenModel.obtainEvent(AuthEvent.AuthClick)
                    }, text = "Войти",
                    isProgressBarVisible = state.value.isLoading
                )
            }
        }
    }
}