package ru.sportivityteam.vucmirea.assistant.core.uikit.mvi

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseStateScreenModel<ViewState : Any, ViewAction, ViewEvent>(initialState: ViewState) :
    ScreenModel {
    private val _viewStates = MutableStateFlow(initialState)

    private val _viewActions =
        MutableSharedFlow<ViewAction?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun viewActions(): WrappedSharedFlow<ViewAction?> =
        WrappedSharedFlow(_viewActions.asSharedFlow())

    fun viewStates(): WrappedStateFlow<ViewState> =
        WrappedStateFlow(_viewStates.asStateFlow())


    protected var viewAction: ViewAction?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }

    protected var viewState: ViewState
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    abstract fun obtainEvent(viewEvent: ViewEvent)
}