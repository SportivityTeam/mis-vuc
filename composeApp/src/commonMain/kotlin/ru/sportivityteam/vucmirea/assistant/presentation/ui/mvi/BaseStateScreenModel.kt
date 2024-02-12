package ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseStateScreenModel<ViewState, ViewAction, ViewEvent>(initialState: ViewState) :
    StateScreenModel<ViewState>(initialState) {
    private val _viewActions =
        MutableSharedFlow<ViewAction?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun viewActions(): WrappedSharedFlow<ViewAction?> =
        WrappedSharedFlow(_viewActions.asSharedFlow())

    protected var viewAction: ViewAction?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }

    abstract fun obtainEvent(viewEvent: ViewEvent)
}