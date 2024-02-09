package ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


abstract class BaseScreenModel<Action> : ScreenModel {
    private val _viewActions =
        MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun viewActions(): WrappedSharedFlow<Action?> =
        WrappedSharedFlow(_viewActions.asSharedFlow())

    protected var viewAction: Action?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }
}

@Composable
inline fun <T> StateFlow<T>.observeAsState(context: CoroutineContext = EmptyCoroutineContext): State<T> {
    return collectAsState(context = context)
}

@Composable
inline fun <T> SharedFlow<T>.observeAsState(context: CoroutineContext = EmptyCoroutineContext): State<T?> {
    return collectAsState(initial = null, context = context)
}