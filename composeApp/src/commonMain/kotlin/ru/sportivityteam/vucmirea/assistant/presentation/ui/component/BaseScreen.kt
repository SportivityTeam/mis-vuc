package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.sportivityteam.vucmirea.assistant.theme.AppTheme

abstract class BaseScreen : Screen {
    private var keyboardController: SoftwareKeyboardController? = null

    @Composable
    override fun Content() {
        keyboardController = LocalSoftwareKeyboardController.current
        AppTheme {
            CompositionLocalProvider {
                Box(
                    contentAlignment = Alignment.TopCenter,
                ) {
                    Column(
                        modifier = Modifier
                            .width(600.dp)
                    ) {
                        ScreenContent()
                    }
                }
            }
        }
    }

    fun hideKeyboard() {
        keyboardController?.hide()
    }

    @Composable
    abstract fun ScreenContent()
}