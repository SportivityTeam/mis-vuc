package ru.sportivityteam.vucmirea.assistant.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import cafe.adriel.voyager.core.screen.Screen
import ru.sportivityteam.vucmirea.assistant.theme.AppTheme

abstract class BaseScreen : Screen {

    @Composable
    override fun Content() {
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

    @Composable
    fun OnPause(doOnPause: () -> Unit) {
        LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) {
            doOnPause()
        }
    }

    @Composable
    abstract fun ScreenContent()
}