package ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface MviView<in VS : Any, out VI : BaseViewIntents> {
    fun render(viewState: VS)
    val intents: VI
}

open class BaseViewIntents {
    private val intentRelay = MutableSharedFlow<UiIntent>(extraBufferCapacity = 5)

    internal val stream: Flow<UiIntent> = intentRelay

    fun intent(name: String = "name-${System.nanoTime()}"): UiIntentFactory0 {
        return UiIntentFactory0(name, intentRelay)
    }

    fun <T : Any> intent(name: String = "name-${System.nanoTime()}"): UiIntentFactory1<T> {
        return UiIntentFactory1(name, intentRelay)
    }
}