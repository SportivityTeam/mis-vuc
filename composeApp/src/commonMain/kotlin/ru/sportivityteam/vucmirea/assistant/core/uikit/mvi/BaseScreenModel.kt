package ru.sportivityteam.vucmirea.assistant.core.uikit.mvi

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


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